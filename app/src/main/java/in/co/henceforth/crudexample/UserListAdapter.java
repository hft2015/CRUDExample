package in.co.henceforth.crudexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class UserListAdapter extends ArrayAdapter<User> {

    Context context;

    public UserListAdapter(Context cxt, int resource, List<User> objects) {
        super(cxt, resource, objects);
        context = cxt;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = convertView;
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if(itemView == null)
            itemView = mInflater.inflate(R.layout.list_item,parent,false);

        User user = getItem(position);

        itemView.setTag(user.getID());

        TextView displayName = (TextView) itemView.findViewById(R.id.displayName);
        displayName.setText(user.getName());

        TextView displayEmail = (TextView) itemView.findViewById(R.id.displayEmail);
        displayEmail.setText(user.getEmail());

        return itemView;
    }
}
