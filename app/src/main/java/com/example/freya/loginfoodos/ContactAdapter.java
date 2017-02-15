package com.example.freya.loginfoodos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter <ContactAdapter.ContactViewHolder>{
    ArrayList<contact>contacts=new ArrayList<contact>();
    private List<contact> filterList;
    Context ctx;
public ContactAdapter(ArrayList<contact>contacts,Context ctx)
{
    this.contacts=contacts;
    this.ctx=ctx;
    this.filterList = new ArrayList<contact>();
    this.filterList.addAll(this.contacts);
}
    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext() ).inflate(R.layout.card_view_layout,parent,false);
        ContactViewHolder contactViewHolder=new ContactViewHolder(view,ctx,contacts);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        contact CON=contacts.get(position);
        holder.img.setImageResource(CON.getImage_id());
        holder.name.setText(CON.getName());
        holder.loc.setText(CON.getLoc());

    }

    @Override
    public int getItemCount() {
        return contacts.size() ;
    }
    public static class ContactViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener
    {
        ImageView img;
        TextView name,loc;
        Context ctx;
        ArrayList<contact>contacts=new ArrayList<contact>();
        public  ContactViewHolder(View view,Context ctx,ArrayList<contact> contacts)
        {
            super(view);
            this.contacts=contacts;
            this.ctx=ctx;
            view.setOnClickListener(this);
            img=(ImageView)view.findViewById(R.id.contact_image);
            name=(TextView)view.findViewById(R.id.title1);
            loc=(TextView)view.findViewById(R.id.title2);
        }

        @Override
        public void onClick(View view) {
           int position=getAdapterPosition();
            contact contact=this.contacts.get(position);
          if(position==0)
                {
                    Intent intent=new Intent(this.ctx,Firstdetail.class);
                    this.ctx.startActivity(intent);
                }
                else if(position==1)
                {
                    Intent intent=new Intent(this.ctx,Seconddetail.class);
                    this.ctx.startActivity(intent);
                }
                else
                {
                    Intent intent=new Intent(this.ctx,Thirddetail.class);
                    this.ctx.startActivity(intent);
                }
            }


        }

    }

