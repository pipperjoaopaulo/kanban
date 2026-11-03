package com.joaopaulo.kanban.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.joaopaulo.kanban.data.model.Status
import com.joaopaulo.kanban.data.model.Task
import com.joaopaulo.kanban.databinding.ItemTaskBinding
//tirar anoatçao//

class TaskAdapter(
    private val context: Context  ,
    private val taskList:List<Task> ,
    private val taskSelected: (Task,Int) -> Unit
): RecyclerView.Adapter<TaskAdapter.MyViewHolder> () {

    companion object{
        val SELECT_BACK:Int = 1
        val SELECT_REMOVER:Int = 2
        val SELECT_EDIT:Int = 3
        val SELECT_DETAILS:Int = 4
        val SELECT_NEXT:Int = 5
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = taskList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val task = taskList[position]
        holder.binding.textDescription.text = task.description

        setIndicators(task,holder)
    }
    private fun setIndicators(task: Task, holder: MyViewHolder){
        when (task.status){
            Status.TODO -> {
                holder.binding.buttonBack.isVisible = false
            }
            Status.DOING -> {
                holder.binding.buttonBack.setColorFilter( ContextCompat.getColor(context, R.color.color_status_todo))
                holder.binding.buttonForward.setColorFilter( ContextCompat.getColor(context, R.color.color_status_done))
            }
            Status.DONE -> {
                holder.binding.buttonForward.isVisible = false
            }
        }
    }

    inner class MyViewHolder(val binding : ItemTaskBinding): RecyclerView.ViewHolder(binding.root){

    }
}