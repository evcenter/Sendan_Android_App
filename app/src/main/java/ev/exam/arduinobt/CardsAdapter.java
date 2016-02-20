package ev.exam.arduinobt;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;

/**
 * Created by pccrazy on 2/10/16.
 */
public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.ledCardViewHolder> {

    List<String> led;
    public CardsAdapter(List<String> led) {
        this.led=led;
    }

    @Override
    public CardsAdapter.ledCardViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.ledcard, viewGroup, false);

        return new ledCardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CardsAdapter.ledCardViewHolder holder, int position) {

        holder.ledname.setText(led.get(position));
    }

    @Override
    public int getItemCount() {
        return led.size();
    }

    public static class ledCardViewHolder extends RecyclerView.ViewHolder {

        TextView ledname;
        SwitchCompat ledswitch;
        public ledCardViewHolder(View itemView) {
            super(itemView);
            ledname=(TextView)itemView.findViewById(R.id.ledid);
            ledswitch=(SwitchCompat)itemView.findViewById(R.id.ledswitch);


        }
    }
}
