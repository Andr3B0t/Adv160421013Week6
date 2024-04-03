package com.ubaya.adv160421013week6.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.adv160421013week6.databinding.OperatorListItemBinding
import com.ubaya.adv160421013week6.model.Operator

class OperatorListAdapter(val operatorList:ArrayList<Operator>)
    :RecyclerView.Adapter<OperatorListAdapter.OperatorViewHolder>()
{
    class OperatorViewHolder(var binding: OperatorListItemBinding)
        :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OperatorViewHolder {
        val binding = OperatorListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return OperatorViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return operatorList.size

    }

    override fun onBindViewHolder(holder: OperatorViewHolder, position: Int) {
        holder.binding.txtID.text = operatorList[position].id
        holder.binding.txtCodename.text = operatorList[position].name
        holder.binding.txtRole.text = operatorList[position].role
        var faction = operatorList[position].faction.name +" : "+operatorList[position].faction.position
        holder.binding.txtFaction.text = faction
        var traits = ""
        for (trait in operatorList[position].traits) {
            traits += "[$trait] "
        }
        holder.binding.txtTraits.text = traits

    }

    fun updateOperatorList(newStudentList: ArrayList<Operator>) {
        operatorList.clear()
        operatorList.addAll(newStudentList)
        notifyDataSetChanged()
    }

}