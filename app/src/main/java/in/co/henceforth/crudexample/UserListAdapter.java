package in.co.henceforth.crudexample;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        itemView.setTag(user.get_id());



        TextView displayName = (TextView) itemView.findViewById(R.id.displayName);
        displayName.setText(user.get_fname() + " " + user.get_lname());

        TextView displayEmail = (TextView) itemView.findViewById(R.id.displayMobile);
        displayEmail.setText(user.get_pic());

        ImageView imageView = (ImageView) itemView.findViewById(R.id.displayIcon);


        if (user.get_pic() == "noimage") {

        }else{


            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageURI(Uri.parse(user.get_pic()));
        }



        return itemView;
    }
}
