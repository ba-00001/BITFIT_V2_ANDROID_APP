package com.example.bitfit_v2_android_app


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class FoodAdapter(
    private val context: Context,
    private val food: MutableList<FoodEntity>) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.food_fragment, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val foodEntity = food[position]
        holder.bind(foodEntity)
    }

    override fun getItemCount() : Int{
        return food.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val foodNameView = itemView.findViewById<TextView>(R.id.food_name)
        private val foodCalorieView = itemView.findViewById<TextView>(R.id.food_calories)
        private val foodPriceView = itemView.findViewById<TextView>(R.id.food_price)

        fun bind(foodItem: FoodEntity) {
            foodNameView.text = foodItem.foodName
            foodCalorieView.text = foodItem.foodCalories
            foodPriceView.text = foodItem.foodPrice
        }
    }
}