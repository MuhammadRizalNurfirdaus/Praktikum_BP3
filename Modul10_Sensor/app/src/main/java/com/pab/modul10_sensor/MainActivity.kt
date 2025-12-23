package com.pab.modul10_sensor

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.hardware.camera2.CameraManager
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var proximitySensor: Sensor? = null

    private lateinit var cameraManager: CameraManager
    private var cameraId: String? = null

    private lateinit var vibrator: Vibrator

    private lateinit var mainLayout: View
    private lateinit var warningText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // System services
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        // Sensors
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

        // UI
        mainLayout = findViewById(R.id.mainLayout)
        warningText = findViewById(R.id.warningTextView)

        // Camera torch id
        initCameraId()
    }

    private fun initCameraId() {
        try {
            cameraId = cameraManager.cameraIdList.firstOrNull()
        } catch (_: Exception) {
            cameraId = null
        }
    }

    override fun onResume() {
        super.onResume()
        proximitySensor?.let { sensor ->
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
        turnOffFlash()
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type != Sensor.TYPE_PROXIMITY) return
        val prox = proximitySensor ?: return
        val isNear = event.values.isNotEmpty() && event.values[0] < prox.maximumRange
        if (isNear) {
            triggerProximityAlerts()
        } else {
            resetUI()
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // No-op
    }

    private fun triggerProximityAlerts() {
        turnOnFlash()
        vibrateOnce(300)
        mainLayout.setBackgroundColor(Color.RED)
        warningText.setText(R.string.too_close)
    }

    private fun resetUI() {
        turnOffFlash()
        mainLayout.setBackgroundColor(Color.WHITE)
        warningText.setText(R.string.proximity_active)
    }

    private fun turnOnFlash() = setFlashlight(true)
    private fun turnOffFlash() = setFlashlight(false)

    private fun setFlashlight(status: Boolean) {
        val id = cameraId ?: return
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cameraManager.setTorchMode(id, status)
            }
        } catch (_: Exception) {
            // Ignore failures (no camera/permission unavailable)
        }
    }

    private fun vibrateOnce(durationMs: Long) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(
                VibrationEffect.createOneShot(durationMs, VibrationEffect.DEFAULT_AMPLITUDE)
            )
        } else {
            @Suppress("DEPRECATION")
            vibrator.vibrate(durationMs)
        }
    }
}
