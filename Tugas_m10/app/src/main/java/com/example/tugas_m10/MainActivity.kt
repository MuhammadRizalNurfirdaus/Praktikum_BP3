package com.example.tugas_m10

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale
import kotlin.math.abs
import kotlin.math.sqrt

class MainActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null

    private lateinit var tvXValue: TextView
    private lateinit var tvYValue: TextView
    private lateinit var tvZValue: TextView
    private lateinit var tvStatus: TextView
    private lateinit var viewIndicator: View

    private var lastX = 0f
    private var lastY = 0f
    private var lastZ = 0f

    private val SHAKE_THRESHOLD = 15.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize views
        tvXValue = findViewById(R.id.tvXValue)
        tvYValue = findViewById(R.id.tvYValue)
        tvZValue = findViewById(R.id.tvZValue)
        tvStatus = findViewById(R.id.tvStatus)
        viewIndicator = findViewById(R.id.viewIndicator)

        // Initialize sensor manager
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        // Check if accelerometer is available
        if (accelerometer == null) {
            Toast.makeText(this, "Accelerometer sensor tidak tersedia!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Accelerometer sensor siap digunakan", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        // Register sensor listener
        accelerometer?.also { acc ->
            sensorManager.registerListener(this, acc, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        // Unregister sensor listener to save battery
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]

            // Update UI with sensor values
            tvXValue.text = String.format(Locale.getDefault(), "%.2f m/s²", x)
            tvYValue.text = String.format(Locale.getDefault(), "%.2f m/s²", y)
            tvZValue.text = String.format(Locale.getDefault(), "%.2f m/s²", z)

            // Calculate the change in acceleration
            val deltaX = abs(x - lastX)
            val deltaY = abs(y - lastY)
            val deltaZ = abs(z - lastZ)

            // Detect movement/shake
            if (deltaX > SHAKE_THRESHOLD || deltaY > SHAKE_THRESHOLD || deltaZ > SHAKE_THRESHOLD) {
                updateStatus("Bergerak Kuat!", "#F44336")
            } else if (deltaX > 5 || deltaY > 5 || deltaZ > 5) {
                updateStatus("Bergerak", "#FF9800")
            } else {
                updateStatus("Diam", "#4CAF50")
            }

            // Store current values for next comparison
            lastX = x
            lastY = y
            lastZ = z

            // Update indicator color based on movement intensity
            val movementIntensity = (deltaX + deltaY + deltaZ) / 3
            updateIndicatorColor(movementIntensity)
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Handle sensor accuracy changes if needed
        when (accuracy) {
            SensorManager.SENSOR_STATUS_UNRELIABLE -> {
                // Sensor is unreliable
            }
            SensorManager.SENSOR_STATUS_ACCURACY_LOW -> {
                // Low accuracy
            }
            SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM -> {
                // Medium accuracy
            }
            SensorManager.SENSOR_STATUS_ACCURACY_HIGH -> {
                // High accuracy
            }
        }
    }

    private fun updateStatus(status: String, color: String) {
        tvStatus.text = status
        tvStatus.setTextColor(Color.parseColor(color))
    }

    private fun updateIndicatorColor(intensity: Float) {
        val color = when {
            intensity > SHAKE_THRESHOLD -> "#F44336" // Red for strong movement
            intensity > 5 -> "#FF9800" // Orange for moderate movement
            else -> "#4CAF50" // Green for no/low movement
        }
        viewIndicator.setBackgroundColor(Color.parseColor(color))
    }
}

