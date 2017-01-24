package com.example.marcelo.exemplolistviewbaseadapter.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.marcelo.exemplolistviewbaseadapter.R;
import com.example.marcelo.exemplolistviewbaseadapter.model.Pessoa;

import java.util.ArrayList;

/**
 * Created by Marcelo on 24/01/2017.
 */

public class PessoaAdapter extends BaseAdapter {
    // Cria varialvel int que ira receber o id do layout inflado.
    private ArrayList<Pessoa> pessoaArrayList;
    private Context context;

    public PessoaAdapter(ArrayList<Pessoa> pessoaArrayList, Context context) {
        this.pessoaArrayList = pessoaArrayList;
        this.context = context;
    }
    // Retorna o tamanho da lista.
    @Override
    public int getCount() {
        return pessoaArrayList.size();
    }
    // Retorna a posição na lista.
    @Override
    public Object getItem(int position) {
        return pessoaArrayList.get(position);
    }
    // Retorna o Id da classe. (Não estou usando Id para Pessoa)
    @Override
    public long getItemId(int position) {
        return position;
    }
    // Infla a view que sera mostrada no ListView e seta os valores dos campos.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.activity_listview_pessoa, parent, false);
        }
        // Recupera os views da activity inflada.
        TextView nome = (TextView) convertView.findViewById(R.id.tv_nome);
        TextView email = (TextView) convertView.findViewById(R.id.tv_email);
        TextView sexo = (TextView) convertView.findViewById(R.id.tv_sexo);

        // Cria um novo objeto pessoa que recebe a posição do item.
        Pessoa pessoa = pessoaArrayList.get(position);
        // Seta valores dos TextViews recuperados.
        nome.setText(pessoa.getNome());
        email.setText(pessoa.getEmail());
        sexo.setText(pessoa.getSexo());

        return convertView;
    }
}
