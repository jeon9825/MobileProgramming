package cse.mobile.dialogtest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btDialog = findViewById(R.id.btDialog);
        btDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*                AlertDialog.Builder adBuilder = new AlertDialog.Builder(MainActivity.this);
                adBuilder.setMessage("Time out!");
                adBuilder.setTitle("Notice");
                adBuilder.setIcon(R.mipmap.ic_launcher);
                adBuilder.show();   */

                new AlertDialog.Builder(MainActivity.this)
                .setMessage("Time out!")
                .setTitle("Notice")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setCancelable(false)
                .show();

            }
        });

        Button btNotieDialog = findViewById(R.id.btNoticeDialog);
        btNotieDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment noticeDialogFragment = new NoticeDialogFragment();
                noticeDialogFragment.setCancelable(false);
                noticeDialogFragment.show(getSupportFragmentManager(), "noticeDialogFragment");
            }
        });

//        final DialogFragment listDialogFragment = new ListDialogFragment();
        final DialogFragment listDialogFragment = new ListDialog2Fragment();
        Button btListDialog = findViewById(R.id.btListDialog);
        btListDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                DialogFragment listDialogFragment = new ListDialogFragment();
                listDialogFragment.setCancelable(false);
                listDialogFragment.show(getSupportFragmentManager(), "listDialogFragment");
            }
        });

    }

    public static class NoticeDialogFragment extends DialogFragment {
        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            AlertDialog.Builder adBuilder = new AlertDialog.Builder(getActivity());
            adBuilder.setMessage("Time out!")
            .setTitle("Notice")
            .setIcon(R.mipmap.ic_launcher)
            .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            })
            .setCancelable(false);
            return adBuilder.create();
        }
    }

    public static class ListDialogFragment extends DialogFragment {
        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            final CharSequence[] items = {"Red", "Green", "Blue"};
            boolean[] checkedItems ={true, false, true};

            AlertDialog.Builder adBuilder = new AlertDialog.Builder(getActivity());
            adBuilder.setTitle("Dialog with List")
/*            .setItems(items, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    Toast.makeText(getActivity(), items[which], Toast.LENGTH_SHORT).show();
                }
            }) */
/*            .setSingleChoiceItems(items, 2, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    Toast.makeText(getActivity(), items[which], Toast.LENGTH_SHORT).show();
                }
            }) */
                    .setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                            String str = (isChecked)? " Checked": " Unchecked";
                            Toast.makeText(getActivity(), items[which] + str, Toast.LENGTH_SHORT).show();
//                    checkedItems[which] = isChecked;
                        }
                    })
                    .setPositiveButton("Close", null)
                    .setCancelable(false);

            return adBuilder.create();
        }
    }

    public static class ListDialog2Fragment extends DialogFragment {
        final static CharSequence[] items = {"Red", "Green", "Blue"};
        boolean[] mCheckedItems ={true, false, true};

        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

            if(savedInstanceState != null) {
                mCheckedItems = savedInstanceState.getBooleanArray("checkedItems");
            }

            AlertDialog.Builder adBuilder = new AlertDialog.Builder(getActivity());
            adBuilder.setTitle("Dialog with List")
/*            .setItems(items, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    Toast.makeText(getActivity(), items[which], Toast.LENGTH_SHORT).show();
                }
            }) */
/*            .setSingleChoiceItems(items, 2, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    Toast.makeText(getActivity(), items[which], Toast.LENGTH_SHORT).show();
                }
            }) */
                    .setMultiChoiceItems(items, mCheckedItems, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                            String str = (isChecked)? " Checked": " Unchecked";
                            Toast.makeText(getActivity(), items[which] + str, Toast.LENGTH_SHORT).show();
//                    checkedItems[which] = isChecked;
                        }
                    })
                    .setPositiveButton("Close", null)
                    .setCancelable(false);

            return adBuilder.create();
        }

        @Override
        public void onSaveInstanceState(@NonNull Bundle outState) {
            super.onSaveInstanceState(outState);
            outState.putBooleanArray("checkedItems", mCheckedItems);
        }
    }
}
