package grupo1.sw2.ulima.foodtracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import grupo1.sw2.ulima.foodtracker.dto.Gusto;

/**
 * Created by stmorzan on 05/10/2015.
 */
public class GustosAdapter extends BaseAdapter{

    private List<Gusto> gustos;
    private LayoutInflater inflater;

    public GustosAdapter(List<Gusto> gustos, Context context){
        this.gustos = gustos;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return gustos.size();
    }

    @Override
    public Object getItem(int position) {
        return gustos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return gustos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView = inflater.inflate(R.layout.item_gusto, null);
        }

        Gusto gusto = gustos.get(position);
        //llamar el nombre del gusto. De acuerdo al nombre, colocar la imagen.

        return convertView;
    }
}


