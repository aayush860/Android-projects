package com.example.anew.ifm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

//import static com.example.anew.ifm.MainActivity.namexxx;

/**
 * Created by new on 08-04-2018.
 */

public class googleinterface extends AppCompatActivity{
    private static final String TAG = "GoogleActivity";
    private static final int RC_SIGN_IN = 9001;
    public static final String MyPREFERENCES = "MyPrefs" ;
    // [START declare_auth]
    private FirebaseAuth gAuth;
    public static final String namexxx = "nameKey";

    // [END declare_auth]
    SharedPreferences sharedpreferences;
    public static final String eml = "email";
    private GoogleSignInClient mGoogleSignInClient;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.google);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("905275218045-ag8l6403su7uofo238t3fbs1008f1lg3.apps.googleusercontent.com")
                .requestEmail()
                .build();
        // [END config_signin]

        mGoogleSignInClient = GoogleSignIn.getClient(googleinterface.this, gso);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        // [START initialize_auth]
        gAuth = FirebaseAuth.getInstance();
signInx();
        Toast.makeText(this, "Please Wait...", Toast.LENGTH_LONG).show();
    }








    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        signOutx();
        FirebaseUser currentUser = gAuth.getCurrentUser();

        updateUIx(currentUser);
    }




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
   //     Toast.makeText(this, ""+Integer.toString(requestCode), Toast.LENGTH_SHORT).show();
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {

                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
                // [START_EXCLUDE]
                updateUIx(null);
                // [END_EXCLUDE]
            }
        }
    }
    // [END onactivityresult]

    // [START auth_with_google]
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
        // [START_EXCLUDE silent]
//        showProgressDialog();
        // [END_EXCLUDE]

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        gAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser userx = gAuth.getCurrentUser();
                            updateUIx(userx);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Snackbar.make(findViewById(R.id.main_layout), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
                            updateUIx(null);
                        }

                        // [START_EXCLUDE]
//                        hideProgressDialog();
                        // [END_EXCLUDE]
                    }
                });
    }
    // [END auth_with_google]

    // [START signin]
    private void signInx() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    // [END signin]

    private void signOutx() {
        // Firebase sign out
        gAuth.signOut();

        // Google sign out
        mGoogleSignInClient.signOut().addOnCompleteListener(this,
                new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        updateUIx(null);
                    }
                });
    }

    private void revokeAccess() {
        // Firebase sign out
        gAuth.signOut();

        // Google revoke access
        mGoogleSignInClient.revokeAccess().addOnCompleteListener(this,
                new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        updateUIx(null);
                    }
                });
    }

    private void updateUIx(FirebaseUser userx) {
        //hideProgressDialog();
        if (userx != null) {
            //          mStatusTextView.setText(getString(R.string.google_status_fmt, user.getEmail()));
            //        mDetailTextView.setText(getString(R.string.firebase_status_fmt, user.getUid()));


            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(namexxx, ""+userx.getDisplayName());
            editor.putString(eml, ""+userx.getEmail());
            editor.commit();
            editor.apply();

        //    Toast.makeText(this, ""+userx.getEmail(), Toast.LENGTH_SHORT).show();
          //  Toast.makeText(this, ""+userx.getPhoneNumber(), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Welcome "+userx.getDisplayName(), Toast.LENGTH_SHORT).show();
            Intent inx=new Intent(googleinterface.this,ImageViewerr.class);
            startActivity(inx);


        } else {
           // Toast.makeText(this, "google out", Toast.LENGTH_SHORT).show();
//            findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);

        }
    }

}