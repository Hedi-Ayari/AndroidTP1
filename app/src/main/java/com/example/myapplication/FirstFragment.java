    package com.example.myapplication;

    import android.os.Bundle;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.Toast;
    import android.widget.TextView;
    import androidx.annotation.NonNull;
    import androidx.fragment.app.Fragment;
    import androidx.navigation.Navigation;

    public class FirstFragment extends Fragment {

        private TextView showCountTextView;

        @Override
        public View onCreateView(
                LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState
        ) {
            View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);
            showCountTextView = fragmentFirstLayout.findViewById(R.id.textview_first);
            return fragmentFirstLayout;
        }

        public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            view.findViewById(R.id.toast_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast myToast = Toast.makeText(getActivity(), "Hello toast!", Toast.LENGTH_SHORT);
                    myToast.show();
                }
            });

            view.findViewById(R.id.count_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    countMe(view);
                }
            });

            view.findViewById(R.id.random_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment);
                }
            });
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
        }

        private void countMe(View view) {
            String countString = showCountTextView.getText().toString();
            Integer count = Integer.parseInt(countString);
            count++;
            showCountTextView.setText(count.toString());
        }
    }
