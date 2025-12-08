package com.pab.modul7_recycle_view

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListKampusAdapter(private val listKampus: ArrayList<Kampus>) :
    RecyclerView.Adapter<ListKampusAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_kampus, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val kampus = listKampus[position]
        val nama = kampus.nama
        val lokasi = kampus.lokasi
        val sejarah = kampus.sejarah
        val photo = kampus.photo

        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = nama
        holder.tvLokasi.text = lokasi
        holder.tvSejarahKampus.text = sejarah

        // Handling click pada item
        holder.itemView.setOnClickListener { view ->
            val context = holder.itemView.context
            val builder = AlertDialog.Builder(context)

            builder.setIcon(photo)
            builder.setMessage("$lokasi\n$sejarah")
            builder.setTitle("Detail Kampus: $nama")
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss() // Menutup dialog ketika tombol OK ditekan
            }

            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }

    override fun getItemCount(): Int = listKampus.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvLokasi: TextView = itemView.findViewById(R.id.tv_item_lokasi)
        val tvSejarahKampus: TextView = itemView.findViewById(R.id.tv_sejarah_kampus)
    }
}