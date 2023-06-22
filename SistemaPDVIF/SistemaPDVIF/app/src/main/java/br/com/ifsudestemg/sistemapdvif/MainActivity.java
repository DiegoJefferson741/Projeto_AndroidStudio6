package br.com.ifsudestemg.sistemapdvif;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import br.com.ifsudestemg.sistemapdvif.ui.CadPacienteActivity;
import br.com.ifsudestemg.sistemapdvif.ui.ListagemPacienteFragment;

public class MainActivity extends AppCompatActivity {

    /**
     * Variável utilizada para saber quando fragmento está seleciondo na
     * tela
     */
    private int id_fragmento = 3; //Consulta

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuprincipal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (id){

            case R.id.action_cadastropaciente:

                id_fragmento = 1;
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, ListagemPacienteFragment.class, null)
                        .commit();
                break;
            case R.id.action_cadastromedico:

                id_fragmento = 2;
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, ListagemMedicoFragment.class, null)
                        .commit();
                break;

            case R.id.action_cadastroconsulta:
                id_fragmento = 3;
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, ListagemConsultaFragment.class, null)
                        .commit();

                break;

            case R.id.action_incluir:

                incluir();

                break;

            case R.id.acton_sair:
                finish();

                break;
        }


        return super.onOptionsItemSelected(item);
    }

    private void incluir() {

        Intent it = null;

        switch (id_fragmento){

            case 1: //Paciente

                it = new Intent(this, CadPacienteActivity.class);
                startActivityForResult(it, id_fragmento);

                break;
            case 2: //Medico

                it = new Intent(this, CadMedicoActivity.class);
                startActivityForResult(it, id_fragmento);

                break;

            case 3: //Consulta

                it = new Intent(this, CadConsultaActivity.class);
                startActivityForResult(it, id_fragmento);

                break;

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        FragmentManager fragmentManager = null;

        if (resultCode == ResultCodeActivity.OK){

            switch (id_fragmento) {

                case 1: //Paciente
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainer, ListagemPacienteFragment.class, null)
                            .commit();
                    break;
                case 2: //Medico
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainer, ListagemMedicoFragment.class, null)
                            .commit();
                    break;
                case 3: //Consulta
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainer, ListagemConsultaFragment.class, null)
                            .commit();

                    break;
            }



        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}