package com.example.kotlinproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinproject.model.Questions
import java.util.ArrayList

class ViewAdapter :
    RecyclerView.Adapter<ViewAdapter.ItemViewHolder>() {

    private var questions = ArrayList<Questions>()

    fun setUpdatedData(questions: ArrayList<Questions>) {
        this.questions = questions
        notifyDataSetChanged()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        holder.bind(questions[position])
    }

    override fun getItemCount(): Int {
        return questions.size

    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var mQuestionTv: TextView = itemView.findViewById(R.id.question_tv)
        private var mOption1: TextView = itemView.findViewById(R.id.option1_tv)
        private var mOption2: TextView = itemView.findViewById(R.id.option2_tv)
        private var mOption3: TextView = itemView.findViewById(R.id.option3_tv)
        private var mOption4: TextView = itemView.findViewById(R.id.option4_tv)
        private var mAnswerTv: TextView = itemView.findViewById(R.id.answer_tv)

        fun bind(data: Questions) {

            mQuestionTv.text = data.mQuestion
            mOption1.text = data.mOptions[0]
            mOption2.text = data.mOptions[1]
            mOption3.text = data.mOptions[2]
            mOption4.text = data.mOptions[3]
            mAnswerTv.text = data.mAnswer

        }

    }
}