package com.capstone.pedotan.ui.dashboard

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.capstone.pedotan.data.SettingsRepository
import com.capstone.pedotan.databinding.ItemFieldBinding
import com.capstone.pedotan.model.Field
import com.capstone.pedotan.ui.camera.CameraActivity
import com.capstone.pedotan.ui.checkfield.CheckFieldActivity

class DashboardViewModel(private val repository: SettingsRepository) : ViewModel() {
    val listFields: List<Field> =
        repository.getFields()
}

class ListMarketAdapter(private val context: Context) : RecyclerView.Adapter<ListMarketAdapter.ListViewHolder>() {
    private val listField = mutableListOf<Field>()

    fun setList(market: List<Field>) {
        val oldSize = listField.size
        listField.clear()
        listField.addAll(market)
        val newSize = listField.size
        notifyItemRangeRemoved(0, oldSize)
        notifyItemRangeInserted(0, newSize)
    }

    inner class ListViewHolder(private var binding: ItemFieldBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(field: Field) {
            binding.apply {
                val position = adapterPosition

                fieldName.text = "Kebun ${field.komoditas} |"
                fieldLuas.text = "${field.luasKebun} Ha"
                fieldLocation.text = field.lokasi
                fieldStatus.text = field.status
                if (field.status == "Kurang") {
                    fieldStatus.setTextColor(Color.RED)
                } else {
                    fieldStatus.setTextColor(Color.GREEN)
                }

                btnCekPenyakit.setOnClickListener {
                    val intent = Intent(context, CameraActivity::class.java)
                    // Add any extra data to the intent if needed
                    intent.putExtra("task", "check penyakit")
                    intent.putExtra("key", listField[position].id)
                    context.startActivity(intent)
                }

                btnCekPenyakit.setOnClickListener {
                    val intent = Intent(context, CheckFieldActivity::class.java)
                    // Add any extra data to the intent if needed
                    intent.putExtra("key", listField[position].id)
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding =
            ItemFieldBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listField[position])
    }

    override fun getItemCount(): Int = listField.size
}