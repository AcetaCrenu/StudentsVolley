package ma.ensa.volley;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class UpdateRoleFragment extends Fragment implements View.OnClickListener {

    private EditText name;
    private Button updateButton;
    private RequestQueue requestQueue;
    private String updateUrl = "http://192.168.8.102:8080/api/v1/roles/%d"; // Modifier l'URL pour correspondre à la mise à jour du rôle
    private long roleId; // Variable pour stocker l'ID du rôle

    public void setRoleId(long id) {
        this.roleId = id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_role, container, false);
        name = view.findViewById(R.id.name); // Remplacez R.id.name par l'ID de votre champ de texte pour le nom du rôle
        updateButton = view.findViewById(R.id.updateButton); // Remplacez R.id.updateButton par l'ID de votre bouton de mise à jour
        updateButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        JSONObject jsonBody = new JSONObject();
        try {
            String inputName = name.getText().toString();
            jsonBody.put("name", inputName);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        requestQueue = Volley.newRequestQueue(requireContext());
        String url = String.format(updateUrl, roleId); // Utilisation de String.format pour remplacer %d par l'ID du rôle
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.PUT, url, jsonBody,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Logique de gestion de la réponse de mise à jour du rôle
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Logique de gestion des erreurs de mise à jour du rôle
            }
        });

        requestQueue.add(request);
    }
}
