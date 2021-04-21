package com.italkutalk.lab8

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection


class MyAdapter(private val data: ArrayList<Contact>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    //實作 RecyclerView.ViewHolder 來儲存 View
    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {
        //連結畫面中的元件
        val tv_name = v.findViewById<TextView>(R.id.tv_name)
        val tv_phone = v.findViewById<TextView>(R.id.tv_phone)
        val img_delete = v.findViewById<ImageView>(R.id.img_delete)
        var temp = 0
        var url = ""
        val imgpicture = v.findViewById<ImageView>(R.id.picture)


    }
    //回傳資料數量
    override fun getItemCount() = data.size
    //建立 ViewHolder 與 Layout 並連結彼此
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int):
            ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.adapter_row, viewGroup, false)
        return ViewHolder(v)
    }
    //將資料指派給元件呈現
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_name.text = data[position].name
        holder.tv_phone.text = data[position].phone
        holder.temp = data[position].picture
        holder.url = data[position].url
        //設定監聽器，使用 removeAt()刪除指定位置的資料
        holder.img_delete.setOnClickListener {
            data.removeAt(position)
            notifyDataSetChanged()
        }
       if(holder.url != ""){
           val picture = loadImageFromURL("https://img.technews.tw/wp-content/uploads/2020/07/14143919/1F34.tmp_-e1594708784769.jpg")
           holder.imgpicture.setImageBitmap(picture)
       }
        else{
           if(holder.temp == 0){
               holder.imgpicture.setImageResource(R.drawable.apple);
           }
           else if(holder.temp == 1){
               holder.imgpicture.setImageResource(R.drawable.tomato);
           }
           else if(holder.temp == 2){
               holder.imgpicture.setImageResource(R.drawable.strawberry);
           }
           else if(holder.temp == 3){
               holder.imgpicture.setImageResource(R.drawable.pineapple);
           }
           else if(holder.temp == 4){
               holder.imgpicture.setImageResource(R.drawable.peach);
           }
           else if(holder.temp == 5){
               holder.imgpicture.setImageResource(R.drawable.orange);
           }
           else if(holder.temp == 6){
               holder.imgpicture.setImageResource(R.drawable.lemon);
           }
           else if(holder.temp == 7){
               holder.imgpicture.setImageResource(R.drawable.grapes);
           }
           else if(holder.temp == 8){
               holder.imgpicture.setImageResource(R.drawable.coconut);
           }
           else if(holder.temp == 9){
               holder.imgpicture.setImageResource(R.drawable.cherries);
           }
           else if(holder.temp == 10){
               holder.imgpicture.setImageResource(R.drawable.banana);
           }
           else if(holder.temp == 11){
               holder.imgpicture.setImageResource(R.drawable.avocado);
           }
        }

    }
    fun loadImageFromURL(src: String): Bitmap? {
        try {
            val url = URL(src)
            val conn = url.openConnection() as HttpsURLConnection
            conn.connect()
            val input = conn.inputStream
            return BitmapFactory.decodeStream(input)
        } catch (e: java.io.IOException) {
            e.printStackTrace()
        }
        return null
    }

}


