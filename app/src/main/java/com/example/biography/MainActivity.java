package com.example.biography;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.biography.Modelos.Biografia;
import com.example.biography.Modelos.Categoria;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.lTabla)
    GridLayout lTabla;
    @BindView(R.id.eBuscar)
    EditText eBuscar;

    private ArrayList<Biografia> biografias;
    private ArrayList<Biografia> biografiasAux;
    private ArrayList<Categoria> categorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        eBuscar.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    filtrar(eBuscar.getText().toString());
                    return true;
                }
                return false;
            }
        });
        inicializar();
    }

    public void inicializar() {
        biografias = new ArrayList<>();
        categorias = new ArrayList<>();
        categorias.add(new Categoria(1, "People"));
        categorias.add(new Categoria(2, "Nostalgia"));
        categorias.add(new Categoria(3, "Celebrity"));
        categorias.add(new Categoria(4, "Histoy & Culture"));
        categorias.add(new Categoria(5, "Crime & Scandal"));
        biografias.add(new Biografia(1000, "https://www.biography.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cg_face%2Cq_auto:good%2Cw_300/MTU3Nzk2NTA0Njc1ODIwNTQ5/rebbeca-marie-gomez-aka-becky-g-poses-for-a-portrait-at-the-2017-latin-american-music-awards-at-dolby-theatre-on-october-25-2017-in-hollywood-california-photo-by-gabriel-olsen_getty-images-square.jpg", "Becky G", "Biography", "Biography.com Editors", "5 de junio de 2016", "California native Becky G (born March 2, 1997; full name Rebbeca Marie Gomez) found fame singing songs like \"Shower\" before moving onto Spanish-language hits such as \"Sin Pijama\" and \"Mayores.\" Her music incorporates rap, pop hooks, reggaeton and Latin influences. In 2013 she signed on as a representative for the beauty line CoverGirl. Becky has guest starred on the television show Empire and was one of the leads in 2017's big-screen Power Rangers adaptation. She began her career as a nine-year-old, following a financial setback that meant her family had to move into her grandparents' garage. All four of Becky's grandparents left Mexico to come to the United States, and she has talked about how their courage and hard work led to more opportunities for their granddaughter.", categorias.get(0)));
        biografias.add(new Biografia(2000, "https://www.biography.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cg_face%2Cq_auto:good%2Cw_300/MTIwNjA4NjM0MjIyODM5MzA4/the-cinema-society--calvin-klein-collection-host-a-screening-of-the-hunger-games---inside-arrivals.jpg", "Liam Hemsworth", "Biography", "Biography.com Editors", "April 2, 2014", "Born on January 13, 1990, in Melbourne, Australia, Liam Hemsworth starred on the soap opera Neighbours before moving to the United States. Not long after, he landed a major role in the film The Last Song (2010), in which he co-starred with future wife Miley Cyrus. Other prominent work for Hemsworth includes The Hunger Games franchise, The Expendables 2 and Catching Fire. His brothers, Luke and Chris Hemsworth, are also actors.", categorias.get(0)));
        biografias.add(new Biografia(3000, "https://www.biography.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cg_face%2Cq_auto:good%2Cw_300/MTE5NDg0MDU1MjQ5NDU0NjA3/david-hasselhoff-15423924-1-402.jpg", "David Hasselhoff", "Biography", "Biography.com Editors", "April 2, 2014", "In 1982, David Hasselhoff landed in prime time for one of the most recognizable roles of his career, that of Michael Knight on the hit show Knight Rider. The series was a huge success in the United States and overseas and made him one of the most recognizable actors on TV. In 1989, Hasselhoff returned to TV to produce and star in the series Baywatch, which became the most watched show in TV history.", categorias.get(0)));
        biografias.add(new Biografia(4000, "https://www.biography.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cg_face%2Cq_auto:good%2Cw_300/MTE4MDAzNDEwNzc2MzI3Njk0/larry-david-9542580-1-402.jpg", "Larry David", "Biography", "Biography.com Editors", "April 2, 2014", "Larry David was born on July 2, 1947, in Brooklyn, New York. In 1982, he was hired as a writer for Saturday Night Live, where he worked for a year. In 1989, Jerry Seinfeld ask David to help him develop a sitcom. David wrote and produced Seinfeld until 1996. He also acted in bit roles. In 1998, he wrote and directed the film Sour Grapes. The following year, he created the critically-acclaimed series Curb Your Enthusiasm for HBO.", categorias.get(0)));
        biografias.add(new Biografia(5000, "https://www.biography.com/.image/c_limit%2Ccs_srgb%2Cq_auto:good%2Cw_860/MTMyOTExMDMyNzg3MDIwNDE5/v2-fresh-prince-castjpg.webp", "", "'The Fresh Prince of Bel-Air': Where Are They Now?", "B. Myint", "September 9, 2015.", "In West Philadelphia, born and raised, on the playground was where I spent most of my days. Chillin’ out maxin’ relaxin’ all cool, and all shootin some b-ball outside of the school...\n" +
                "\n" +
                "If you’re bobbing your head right now and about to belt out the next few lines then you probably know we’re talking about The Fresh Prince of Bel-Air, the title character from the early 90s series that introduced audiences to Will Smith’s adventures with the Banks Family, many, many short jokes, and, of course, the Carlton Dance. This month marks the 28th anniversary of the show. So what is the cast up to these days?", categorias.get(1)));
        biografias.add(new Biografia(6000, "https://www.biography.com/.image/c_limit%2Ccs_srgb%2Cq_auto:good%2Cw_700/MTE4MDAzNDEwMzY0MDQwNzE4/image-title1.webp", "", "'Mystic Pizza' Cast: Where Are They Now?", "Araceli Cruz", "Apr 2, 2014", " Pizza and love never looked so cheesy once the romantic comedy Mystic Pizza hit the big screen 25 years ago today. Starring Julia Roberts, Lili Taylor, and Annabeth Gish, the film was set in the small fishing town of Mystic, Connecticut, where three young working class girls busied themselves serving and guarding the best pizza in town while desperately looking for love in their own haphazardous way.\n" +
                "\n" +
                "Released in 1988, Mystic Pizza received favorable reviews and strong praise from famed critics Siskel and Ebert, mostly for its young and promising cast. The critics said the film would “someday become known for the movie stars it showcased back before they became stars,” which is exactly how the future unfolded.", categorias.get(1)));
        biografias.add(new Biografia(7000, "https://www.biography.com/.image/ar_233:100%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cg_faces:center%2Cq_auto:good%2Cw_1920/MTE5NTU2MzI1Mjg3MzY0MTA3/friends-cast-promo-finaljpg.jpg", "", "‘Friends’ Cast: Where Are They Now?", "Leanne French", "Oct 2, 2018", "On September 22, 1994, Rachel, Monica, Ross, Chandler, Joey, and Phoebe were introduced to America on the sitcom Friends, and it wasn’t long before the show became a TV hit and a hairstyle-inspiring cultural phenomenon. Fans could relate to their 20-something angst, dating ups and downs, and the idea that when all else fails friends “will be there for you.\"\n" +
                "\n" +
                "Friends lasted for 10 seasons (not to mention it’s eternal syndication) and a big part of its success was the chemistry of its tight-knit cast that stuck together onscreen and off. What happened when the \"Friends\" parted ways? Here's a look at their lives then and now...", categorias.get(1)));
        biografias.add(new Biografia(8000, "https://www.biography.com/.image/ar_266:100%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cg_faces:center%2Cq_auto:good%2Cw_2560/MTU4NTkxMDM3Mzg2Nzk0NTcw/hocus-pocus-sarah-jessica-parker-bette-midler-kathy-najimy-1993-cbuena-vista-pictures_courtesy-everett-collection.jpg", "", "Hocus Pocus Cast: Where Are They Now?", "Eudie Pak", "Sep 28, 2018", "It just took a virgin, a lighter and a Black Flame Candle to bring back the Sanderson Sisters from the dead, then POOF! — Hocus Pocus was on its way to becoming a cult classic for Disney. Directed by Kenny Ortega, the 1993 fantasy film starred Bette Midler, Kathy Najimy and Sarah Jessica Parker as three dopey 17th century Salem witches (aka the Sanderson Sisters) who suck the life forces of children to stay young. Fast forward 300 years later to 1993, and the Sanderson Sisters are accidentally resurrected from the dead on Halloween, thanks to a tie-dyed hippie teen named Max who's accompanied by his little sister and the girl of his dreams, Allison. The three of them, along with immortal talking black cat Thackery, take on the witches and their evil spells to save the town of Salem.", categorias.get(1)));
        biografias.add(new Biografia(9000, "https://www.biography.com/.image/ar_233:100%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cg_faces:center%2Cq_auto:good%2Cw_1920/MTU2ODAwNjMxMTQ1NzY4NTYw/gettyimages-141296050.jpg", "", "Freaks and Geeks Cast: Where Are They Now?", "Brad Witter", "Jul 17, 2018", "Although Freaks and Geeks aired for only one season, NBC's short-lived teen dramedy became one of the most popular outcasts in the network's history. Now a cult classic, the early 80s-set show, which aired from 1999-2000, centered on brother and sister Lindsay and Sam Weir along with a crew of misfits battling teenage woes at William McKinley High School.", categorias.get(2)));
        biografias.add(new Biografia(10000, "https://www.biography.com/.image/ar_266:100%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cg_faces:center%2Cq_auto:good%2Cw_2560/MTYwNDg5ODg4ODY3NjkwNDU2/mary-poppins_photo-by-mondadori-portfolio-via-getty-images.jpg", "", "'Mary Poppins' Cast: Where Are They Now?", "'Mary Poppins' Cast: Where Are They Now?", "Dec 12, 2018", "Mary Poppins, shaped by Walt Disney with music and lyrics by Richard and Robert Sherman, was a commercial and critical phenomenon. Poppins marked the big-screen debut of Julie Andrews in the titular role playing a mysterious, magical nanny who literally descends upon a well-to-do household. Her task, ostensibly, is to provide guidance for her two young charges but she is in truth far more concerned with a family’s collective heart.", categorias.get(2)));
        biografias.add(new Biografia(11000, "https://www.biography.com/.image/t_share/MTU5OTEyNzEzOTgyNTg0MzUy/marypoppins.jpg", "", "It Took Walt Disney More Than 20 Years to Make 'Mary Poppins'", "Eudie Pak", "Sep 28, 2018", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", categorias.get(2)));
        biografias.add(new Biografia(12000, "https://www.biography.com/.image/t_share/MTU4OTEwNDg2ODUzNzI0MTMy/photo-by-monty-brinton_cbs-via-getty-images.jpg", "", "The 10 Best Halloween TV Episodes", "Biography.com Editors", "April 2, 2014", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", categorias.get(2)));
        biografias.add(new Biografia(13000, "https://www.biography.com/.image/t_share/MTYxNTM0NzI1NTYxNzg3Njk0/henry-ford-hospital.jpg", "", "How a Horrific Bus Accident Changed Frida Kahlo’s Life", "Biography.com Editors", "April 2, 2014", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", categorias.get(3)));
        biografias.add(new Biografia(14000, "https://www.biography.com/.image/ar_266:100%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cg_faces:center%2Cq_auto:good%2Cw_2560/MTY0NDEyMDEzODEwODIxMDU1/harperleetrumancapote_v3.jpg ", "", "Harper Lee and Truman Capote Were Childhood Friends Until Jealously Tore Them Apart", "Eudie Pak", "Sep 28, 2018", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", categorias.get(3)));
        biografias.add(new Biografia(15000, "https://www.biography.com/.image/t_share/MTU0MzY2OTUyNjIwNDM0NzY4/01_old_paul_interior_balcony_016_re.jpg", "", "Lizzie Borden's Isolated Life After Her Murder Trial", "Biography.com Editors", "April 2, 2014", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", categorias.get(3)));
        biografias.add(new Biografia(16000, "https://www.biography.com/.image/t_share/MTYzNTc1NzEzMDc5NzY0OTI5/jacqueline-kennedy-1929---1994-carries-a-reproduction-of-a-hepplewhite-chair-in-the-red-room-during-a-white-house-restoration-project-washington-dc-july-1961-photo-by-ed-clarkthe-life-picture-collecti.jpg", "", "How Jacqueline Kennedy Transformed the White House and Left a Lasting Legacy", "Biography.com Editors", "April 2, 2014", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", categorias.get(3)));
        biografias.add(new Biografia(17000, "https://www.biography.com/.image/t_share/MTE1ODA0OTcxMjg2MTY5MTAx/image-title3.jpg", "", "The Real Bonnie and Clyde: 9 Facts on the Outlawed Duo", "Eudie Pak", "Sep 28, 2018", "Possibly the most famous and most romanticized criminals in American history, Bonnie Parker and Clyde Barrow were two young Texans whose early 1930s crime spree forever imprinted them upon the national consciousness. Their names have become synonymous with an image of Depression-era chic, a world where women chomped cigars and brandished automatic rifles, men robbed banks and drove away in squealing automobiles, and life was lived fast because it would be so short.", categorias.get(4)));
        biografias.add(new Biografia(18000, "https://www.biography.com/.image/t_share/MTUzMjI4ODA5MzcyNDQ0Mjgw/natalie-wood-1938-1981-us-actress-gazing-at-her-husband-robert-wagner-us-actor-in-a-studio-portrait-against-a-light-blue-background-circa-1975-photo-by-silver-screen-collection_getty-images.jpg", "", "New Questions in Natalie Wood's Death", "Biography.com Editors", "April 2, 2014", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", categorias.get(4)));
        biografias.add(new Biografia(19000, "https://www.biography.com/.image/t_share/MTE4MDAzNDEwMTgxNjU0MDMw/image-title2.jpg", "", "Was the Getty Family Kidnapping a Hoax?", "Eudie Pak", "Sep 28, 2018", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", categorias.get(4)));
        biografias.add(new Biografia(20000, "https://www.biography.com/.image/t_share/MTE5NDg0MDU5NDIyNjU2MDE1/shorty-guzman-editedjpg.jpg", "", "Thug Life: The 5 Most Notorious Drug Kingpins", "Biography.com Editors", "April 2, 2014", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", categorias.get(4)));

        biografiasAux = biografias;
        generar();
    }

    public void filtrar(String texto) {
        boolean encontrado = false;
        biografiasAux = new ArrayList<>();
        for (int i = 0; i < biografias.size(); i++) {
            if ((biografias.get(i).getTitulo().contains(texto)) || (biografias.get(i).getNombre().contains(texto))) {
                biografiasAux.add(biografias.get(i));
                encontrado = true;
            }
        }
        if (!encontrado)
            inicializar();
        generar();
    }

    public void categoria(int idCategoria) {
        biografiasAux = new ArrayList<>();
        for (int i = 0; i < biografias.size(); i++) {
            if (biografias.get(i).getCategorias().getIdCategoria() == idCategoria)
                biografiasAux.add(biografias.get(i));
        }
        generar();
    }

    private void generar() {
        View view;
        ImageView iFoto;
        TextView vNombre;
        TextView vAutorF;
        TextView vCategoria;
        String imagen;
        lTabla.removeAllViews();
        if (biografiasAux.size() > 3) {
            lTabla.setColumnCount(3);
            lTabla.setRowCount(biografiasAux.size() / 3);
        } else if (biografiasAux.size() == 2) {
            lTabla.setColumnCount(3);
            lTabla.setRowCount(biografiasAux.size() / 2);
        } else if (biografiasAux.size() == 1) {
            lTabla.setColumnCount(3);
            lTabla.setRowCount(biografiasAux.size());
        }
        for (int i = 0, c = 0, r = 0; i < biografiasAux.size(); i++, c++) {
            if (c == 3) {
                c = 0;
                r++;
            }
            view = LayoutInflater.from(this).inflate(R.layout.usuario, null);
            iFoto = (ImageView) view.findViewById(R.id.iFoto);
            vNombre = (TextView) view.findViewById(R.id.vTitulo);
            vAutorF = (TextView) view.findViewById(R.id.vAutorF);
            vCategoria = (TextView) view.findViewById(R.id.vCategoria);
            imagen = biografiasAux.get(i).getImagen();
            Picasso.get().load(imagen).into(iFoto);
            vNombre.setText(biografiasAux.get(i).getNombre() + " " + biografiasAux.get(i).getTitulo());
            vAutorF.setText(biografiasAux.get(i).getEscritor() + " - " + biografiasAux.get(i).getFecha());
            vCategoria.setText(biografiasAux.get(i).getCategorias().getCategoria());
            view.setId(biografiasAux.get(i).getIdPersonaje());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int i = 0; i < biografiasAux.size(); i++)
                        if (biografiasAux.get(i).getIdPersonaje() == v.getId()) {
                            Intent detalles = new Intent(MainActivity.this, Detalles.class);
                            detalles.putExtra("detalles", biografiasAux.get(i));
                            startActivity(detalles);
                        }
                }
            });
            lTabla.addView(view, i);
        }
    }


    @OnClick(R.id.bPeople)
    public void peoble() {
        categoria(1);
    }

    @OnClick(R.id.bNostalgia)
    public void nostalgia() {
        categoria(2);
    }

    @OnClick(R.id.bCelebrity)
    public void celebrity() {
        categoria(3);
    }

    @OnClick(R.id.bHistory)
    public void history() {
        categoria(4);
    }

    @OnClick(R.id.bCrime)
    public void crime() {
        categoria(5);
    }

}
