package com.reshika.foodmart.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reshika.foodmart.AddToCartActivity
import com.reshika.foodmart.R
import com.reshika.foodmart.api.ServiceBuilder
import com.reshika.foodmart.entity.Product
import com.reshika.foodmart.model.NoodleModel
import de.hdodenhof.circleimageview.CircleImageView

class NoodleAdapter(
        val noodleList: MutableList<Product>,
        val context: Context
): RecyclerView.Adapter<NoodleAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var noodleImges: ImageView
        var noodleName: TextView

        var value: TextView
        var cart:Button

        init {

            noodleImges=itemView.findViewById(R.id.item_image)

            noodleName=itemView.findViewById(R.id.name)

            value=itemView.findViewById(R.id.value)
            cart=itemView.findViewById(R.id.cart)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.noodles_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return noodleList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val noodle = noodleList[position]
        holder.noodleName.text = noodle.ProductName
        holder.value.text = noodle.ProductPrice
        var image=ServiceBuilder.loadImagePath()
        image+=noodle.ProductImage
        Glide.with(context)
                .load(image)
                .into(holder.noodleImges)

        holder. cart.setOnClickListener() {
            val intent = Intent(context, AddToCartActivity::class.java)
            intent.putExtra("data",noodle)
            context.startActivity(intent)
        }



    }
}


