package com.arivhaysoft.libspinnerketik;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;


import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<ModelData> {

    public ArrayList<ModelData> MainList;

    public ArrayList<ModelData> SubjectListTemp;

    public MyAdapter.SubjectDataFilter subjectDataFilter ;

    public MyAdapter(Context context, int id, ArrayList<ModelData> subjectArrayList) {

        super(context, id, subjectArrayList);

        this.SubjectListTemp = new ArrayList<ModelData>();

        this.SubjectListTemp.addAll(subjectArrayList);

        this.MainList = new ArrayList<ModelData>();

        this.MainList.addAll(subjectArrayList);
    }

    @Override
    public Filter getFilter() {

        if (subjectDataFilter == null){

            subjectDataFilter  = new MyAdapter.SubjectDataFilter();
        }
        return subjectDataFilter;
    }


    public class ViewHolder {

        TextView SubjectName;
        TextView SubjectFullForm;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyAdapter.ViewHolder holder = null;

        if (convertView == null) {

            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = vi.inflate(R.layout.items_view, null);

            holder = new MyAdapter.ViewHolder();

            holder.SubjectName = (TextView) convertView.findViewById(R.id.text1);

            convertView.setTag(holder);

        } else {
            holder = (MyAdapter.ViewHolder) convertView.getTag();
        }

        ModelData subject = SubjectListTemp.get(position);

        holder.SubjectName.setText(subject.getNama());


        return convertView;

    }

    private class SubjectDataFilter extends Filter
    {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            charSequence = charSequence.toString().toLowerCase();

            FilterResults filterResults = new FilterResults();

            if(charSequence != null && charSequence.toString().length() > 0)
            {
                ArrayList<ModelData> arrayList1 = new ArrayList<ModelData>();

                for(int i = 0, l = MainList.size(); i < l; i++)
                {
                    ModelData subject = MainList.get(i);

                    if(subject.getNama().toString().toLowerCase().contains(charSequence))

                        arrayList1.add(subject);
                }
                filterResults.count = arrayList1.size();

                filterResults.values = arrayList1;
            }
            else
            {
                synchronized(this)
                {
                    filterResults.values = MainList;

                    filterResults.count = MainList.size();
                }
            }
            return filterResults;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            SubjectListTemp = (ArrayList<ModelData>)filterResults.values;

            notifyDataSetChanged();

            clear();

            for(int i = 0, l = SubjectListTemp.size(); i < l; i++)
                add(SubjectListTemp.get(i));

            notifyDataSetInvalidated();
        }
    }


}