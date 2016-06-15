package com.cinnamon.digitapp;

import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Christian on 9/6/2016.
 */
public class AdapterRecyclerView extends RecyclerView.Adapter implements View.OnClickListener {

    private View.OnClickListener listener;
    private List<Noticia> listaNoticias;

    public AdapterRecyclerView(List<Noticia> listaNoticias) {
        this.listaNoticias = listaNoticias;
    }
    public void setOnClickListener(View.OnClickListener unListener){
        listener=unListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_detalle,parent,false);
        NoticiaViewHolder noticiaViewHolder=new NoticiaViewHolder(itemView);

        itemView.setOnClickListener(this);
        return noticiaViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Noticia unaNoticia= listaNoticias.get(position);
        NoticiaViewHolder noticiaViewHolder=(NoticiaViewHolder) holder;
        noticiaViewHolder.BindNoticias(unaNoticia);
    }

    @Override
    public int getItemCount() {
        return this.listaNoticias.size();
    }


    @Override
    public void onClick(View view) {
        listener.onClick(view);
    }

    public static class NoticiaViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewTitular;
        private TextView textViewDescripcion;
        private TextView textViewTiempo;
        private ImageView imageViewID;
        private ImageView imageViewCategorias;


        public NoticiaViewHolder(View itemView) {
            super(itemView);
        textViewTitular=(TextView)itemView.findViewById(R.id.text_view_titular);
        textViewDescripcion=(TextView)itemView.findViewById(R.id.text_view_descrpcion);
        textViewTiempo=(TextView)itemView.findViewById(R.id.text_view_tiempo);
        imageViewID=(ImageView) itemView.findViewById(R.id.image_view_vista_previa);
        imageViewCategorias=(ImageView)itemView.findViewById(R.id.image_view_categorias);


        }
        public void BindNoticias(Noticia unaNoticia){

        textViewTitular.setText(unaNoticia.getTitular());
        textViewDescripcion.setText(unaNoticia.getDescripcion());
        textViewTiempo.setText(unaNoticia.getTiempo().toString()+"'");
        imageViewID.setImageResource(unaNoticia.getImagenID());
        imageViewCategorias.setImageResource(unaNoticia.getImagenCategorias());

        }
    }
}
