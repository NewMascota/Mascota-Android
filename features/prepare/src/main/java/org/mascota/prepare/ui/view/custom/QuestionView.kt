package org.mascota.prepare.ui.view.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.ViewCompat
import org.mascota.core.util.extension.getString
import org.mascota.prepare.R
import org.mascota.prepare.databinding.ItemPrepareBinding

class QuestionView(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {
    private val questionItems = (1..5).map {
        ItemPrepareBinding.inflate(LayoutInflater.from(context), null, false).apply {
            root.id = ViewCompat.generateViewId()
        }
    }

    init {
        orientation = VERTICAL
        weightSum = 5f
        initView()
        for (i in 0..4) {
            addView(
                questionItems[i].root.apply {
                    layoutParams = LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        0,
                        1f
                    )
                }
            )
        }
        setQuestionItemClick()
    }

    private fun initView() {
        with(questionItems[0]) {
            tvNumber.text = getString(R.string.number_1)
            tvQuestion.text = getString(R.string.question)
            isWrite = true
            isTopLineInvisible = true
        }

        with(questionItems[1]) {
            tvNumber.text = getString(R.string.number_2)
            tvQuestion.text = getString(R.string.question)
            isWrite = true
        }

        with(questionItems[2]) {
            tvNumber.text = getString(R.string.number_3)
            tvQuestion.text = getString(R.string.question)
            isWrite = false
        }

        with(questionItems[3]) {
            tvNumber.text = getString(R.string.number_4)
            tvQuestion.text = getString(R.string.question)
        }

        with(questionItems[4]) {
            tvNumber.text = getString(R.string.number_5)
            tvQuestion.text = getString(R.string.question)
            isBottomLineInvisible = true
        }
    }

    // TODO : 질문을 하나만 선택하도록
    private fun setQuestionItemClick() {
        with(questionItems[0]) {
            clQuestion.setOnClickListener {
                it.isSelected = !it.isSelected
                tvQuestionDescription.isSelected = it.isSelected
            }
        }

        with(questionItems[1]) {
            clQuestion.setOnClickListener {
                it.isSelected = !it.isSelected
                tvQuestionDescription.isSelected = it.isSelected
            }
        }

        with(questionItems[2]) {
            clQuestion.setOnClickListener {
                it.isSelected = !it.isSelected
                tvQuestionDescription.isSelected = it.isSelected
            }
        }

        with(questionItems[3]) {
            clQuestion.setOnClickListener {
                it.isSelected = !it.isSelected
                tvQuestionDescription.isSelected = it.isSelected
            }
        }

        with(questionItems[4]) {
            clQuestion.setOnClickListener {
                it.isSelected = !it.isSelected
                tvQuestionDescription.isSelected = it.isSelected
            }
        }
    }
}