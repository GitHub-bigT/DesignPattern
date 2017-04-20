package oracle.designpattern.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import oracle.designpattern.R;
import oracle.designpattern.annotation.FindView;
import oracle.designpattern.annotation.FindViewParser;

/**
 * Created by 田帅 on 2017/4/20.
 */

public class LVAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;

    public LVAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.lv_item,null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.mTextView.setText(list.get(position));
        return convertView;
    }
    public class ViewHolder{

        @FindView(id = R.id.tv_lv_item_text)
        TextView mTextView;

        public ViewHolder(View view) {
            FindViewParser.startFind(this,view);
        }
    }
}
