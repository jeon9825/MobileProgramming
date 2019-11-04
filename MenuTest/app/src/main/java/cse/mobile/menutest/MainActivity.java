package cse.mobile.menutest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;

import android.os.Bundle;
//import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ActionMode mActionMode = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        registerForContextMenu(button);

        TextView tvHello = findViewById(R.id.tvHello);
//        registerForContextMenu(tvHello);
        tvHello.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(mActionMode != null) {
                    return false;
                }

//                mActionMode = MainActivity.this.startActionMode(mActionModeCallback);
                mActionMode = MainActivity.this.startSupportActionMode(mActionModeCallback);
                view.setSelected(true);
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menuNew:
                Toast.makeText(this, "OptionsMenu New", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuOpen:
                Toast.makeText(this, "OptionsMenu Open", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
 //       inflater.inflate(R.menu.cmenu_activity_main_button, menu);
//        inflater.inflate(R.menu.cmenu_activity_main_tvhello, menu);
        int cmenuResId = 0;
        switch(v.getId()) {
            case R.id.button:
                cmenuResId = R.menu.cmenu_activity_main_button;
                break;
            case R.id.tvHello:
                cmenuResId = R.menu.cmenu_activity_main_tvhello;
                break;
        }
        inflater.inflate(cmenuResId, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.cmenuCreate:
                Toast.makeText(this, "ContextMenu Create", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.cmenuDelete:
                Toast.makeText(this, "ContextMenu Delete", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.cmenuCopy:
                Toast.makeText(this, "ContextMenu Copy", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.cmenuPaste:
                Toast.makeText(this, "ContextMenu Paste", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);

        }
    }

    ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            MenuInflater inflater = actionMode.getMenuInflater();
            inflater.inflate(R.menu.cmenu_activity_main_tvhello, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch(menuItem.getItemId()) {
                case R.id.cmenuCopy:
                    Toast.makeText(getApplicationContext(), "ContextMenu Copy", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.cmenuPaste:
                    Toast.makeText(getApplicationContext(), "ContextMenu Paste", Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            mActionMode = null;
        }
    };

}
