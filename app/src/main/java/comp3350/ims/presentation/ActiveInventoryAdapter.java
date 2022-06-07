package comp3350.ims.presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import comp3350.ims.R;

public class ActiveInventoryAdapter extends BaseAdapter {
    Context context;
    Inventory activeInventory;
    private static LayoutInflater inflater = null;

    public ActiveInventoryAdapter(Context context, Inventory inventory){
        this.context = context;
        this.activeInventory = inventory;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View vi = convertView;

        if(vi == null){
            vi = inflater.inflate(R.layout.row,null);
        }

        TextView itemName = (TextView) vi.findViewById(R.id.itemName);
        itemName.setText(activeInventory.getItem(position).getName());

        TextView categoryName = (TextView) vi.findViewById(R.id.categoryName);
        categoryName.setText(activeInventory.getItem(position).getCategory());

        TextView itemQuantity = (TextView) vi.findViewById(R.id.itemQuantity);
        itemQuantity.setText(activeInventory.getItem(position).getQuantity());

        TextView itemPrice = (TextView) vi.findViewById(R.id.itemPrice);
        itemPrice.setText(activeInventory.getItem(position).getPrice());

        return vi;
    }

    @Override
    public int getCount(){
        return activeInventory.numItems();
    }

    @Override
    public Object getItem(int position){
        return activeInventory.getItem(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

}
