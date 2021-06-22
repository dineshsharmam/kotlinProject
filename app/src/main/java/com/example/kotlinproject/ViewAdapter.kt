package com.example.kotlinproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewAdapter(context: Context, quiz: Quiz) :
    RecyclerView.Adapter<ViewAdapter.ItemViewHolder>() {

    private var appContext: Context? = context
    private var myquiz: Quiz? = quiz


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(appContext).inflate(R.layout.recycler_view, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.mQuestionTv.text = myquiz!!.mQuestions[position].mQuestion
        holder.mOption1.text = myquiz!!.mQuestions[position].mOptions[0]
        holder.mOption2.text = myquiz!!.mQuestions[position].mOptions[1]
        holder.mOption3.text = myquiz!!.mQuestions[position].mOptions[2]
        holder.mOption4.text = myquiz!!.mQuestions[position].mOptions[3]
        holder.mAnswerTv.text = "Answer: " + myquiz!!.mQuestions[position].mAnswer
    }

    override fun getItemCount(): Int {
        return myquiz!!.mQuestions.size

    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mQuestionTv: TextView = itemView.findViewById(R.id.question_tv)
        var mOption1: TextView = itemView.findViewById(R.id.option1_tv)
        var mOption2: TextView = itemView.findViewById(R.id.option2_tv)
        var mOption3: TextView = itemView.findViewById(R.id.option3_tv)
        var mOption4: TextView = itemView.findViewById(R.id.option4_tv)
        var mAnswerTv: TextView = itemView.findViewById(R.id.answer_tv)

    }
}