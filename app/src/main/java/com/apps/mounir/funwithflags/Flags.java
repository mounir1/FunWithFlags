package com.apps.mounir.funwithflags;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by Mounir on 22.01.2016.
 */
public class Flags extends AppCompatActivity {

    ArrayList<Integer> FlagIds = new ArrayList<>();

    public static int[] Africa = {R.drawable._algeria, R.drawable._angola, R.drawable._benin, R.drawable._botswana, R.drawable._burkina_faso, R.drawable._burundi, R.drawable._cape_verde,
            R.drawable._cameroon, R.drawable._central_african_republic, R.drawable._chad, R.drawable._comoros, R.drawable._democratic_republic_of_the_congo, R.drawable._ivory_coast,
            R.drawable._djibouti, R.drawable._egypt, R.drawable._equatorial_guinea, R.drawable._eritrea, R.drawable._ethiopia, R.drawable._gabon, R.drawable._gambia, R.drawable._ghana,
            R.drawable._guinea, R.drawable._guinea_bissau, R.drawable._kenya, R.drawable._lesotho, R.drawable._libya, R.drawable._liberia, R.drawable._madagascar, R.drawable._malawi, R.drawable._mali,
            R.drawable._mauritania, R.drawable._mauritius, R.drawable._morocco, R.drawable._mozambique, R.drawable._namibia, R.drawable._niger, R.drawable._nigeria, R.drawable._rwanda,
            R.drawable._sao_tome_and_principe, R.drawable._senegal, R.drawable._seychelles, R.drawable._sierra_leone, R.drawable._somalia, R.drawable._south_africa, R.drawable._sudan, R.drawable._swaziland,
            R.drawable._tanzania, R.drawable._togo, R.drawable._republic_of_the_congo, R.drawable._democratic_republic_of_the_congo, R.drawable._tunisia, R.drawable._uganda, R.drawable._western_sahara, R.drawable._zambia, R.drawable._zimbabwe};

    public static int[] Europe =
            {R.drawable._albania, R.drawable._andorra, R.drawable._armenia, R.drawable._austria, R.drawable._azerbaijan, R.drawable._belarus, R.drawable._belgium, R.drawable._bosnia_and_herzegovina, R.drawable._bulgaria,
                    R.drawable._croatia, R.drawable._cyprus, R.drawable._czech_republic, R.drawable._denmark, R.drawable._estonia, R.drawable._finland, R.drawable._france, R.drawable._georgia, R.drawable._germany, R.drawable._greece,
                    R.drawable._hungary, R.drawable._iceland, R.drawable._ireland, R.drawable._italy, R.drawable._kazakhstan, R.drawable._latvia, R.drawable._liechtenstein, R.drawable._lithuania, R.drawable._luxembourg,
                    R.drawable._macedonia, R.drawable._malta, R.drawable._moldova, R.drawable._monaco, R.drawable._montenegro, R.drawable._netherlands, R.drawable._norway, R.drawable._poland, R.drawable._portugal,
                    R.drawable._romania, R.drawable._san_marino, R.drawable._serbia, R.drawable._slovakia, R.drawable._spain, R.drawable._sweden, R.drawable._swaziland, R.drawable._ukraine, R.drawable._united_kingdom,
                    R.drawable._vatican_city};

    public static int[] Asia =
            {R.drawable._afghanistan, R.drawable._bahrain, R.drawable._bangladesh, R.drawable._bhutan, R.drawable._brunei, R.drawable._cambodia, R.drawable._china, R.drawable._east_timor, R.drawable._india,
                    R.drawable._indonesia, R.drawable._iran, R.drawable._iraq, R.drawable._israel, R.drawable._japan, R.drawable._kazakhstan, R.drawable._korea_south, R.drawable._korea_north, R.drawable._kuwait,
                    R.drawable._kyrgyzstan, R.drawable._laos, R.drawable._lebanon, R.drawable._malaysia, R.drawable._maldives, R.drawable._mongolia, R.drawable._nepal, R.drawable._oman, R.drawable._pakistan,
                    R.drawable._palestinian, R.drawable._philippines, R.drawable._qatar, R.drawable._russia, R.drawable._saudi_arabia, R.drawable._singapore, R.drawable._sri_lanka, R.drawable._syria, R.drawable._tajikistan, R.drawable._thailand,
                    R.drawable._turkey, R.drawable._turkmenistan, R.drawable._united_arab_emirates, R.drawable._uzbekistan, R.drawable._vietnam, R.drawable._yemen
            };

    public static int[] NAmerica =
            {R.drawable._antigua_and_barbuda, R.drawable._bahamas, R.drawable._barbados, R.drawable._belize, R.drawable._canada, R.drawable._costa_rica, R.drawable._cuba, R.drawable._dominica, R.drawable._dominican_republic, R.drawable._el_salvador,
                    R.drawable._grenada, R.drawable._guatemala, R.drawable._haiti, R.drawable._honduras, R.drawable._jamaica, R.drawable._mexico, R.drawable._nicaragua, R.drawable._panama, R.drawable._saint_kitts_and_nevis, R.drawable._saint_lucia, R.drawable._saint_vincent_and_the_grenadines, R.drawable._saint_pierre_and_miquelon,
                    R.drawable._saint_barthelemy, R.drawable._saint_helena, R.drawable._saint_martin, R.drawable._trinidad_and_tobago, R.drawable._united_states_of_america};

    public static int[] Oceana =
            {R.drawable._australia, R.drawable._fiji, R.drawable._kiribati, R.drawable._marshall_islands, R.drawable._micronesia, R.drawable._nauru, R.drawable._new_zealand, R.drawable._palau, R.drawable._papua_new_guinea,
                    R.drawable._samoa, R.drawable._solomon_islands, R.drawable._tonga, R.drawable._tuvalu, R.drawable._vanuatu};
    public static int[] SAmerica =
            {R.drawable._argentina, R.drawable._bolivia, R.drawable._brazil, R.drawable._chile, R.drawable._colombia, R.drawable._ecuador, R.drawable._guyana, R.drawable._paraguay, R.drawable._peru, R.drawable._suriname, R.drawable._uruguay, R.drawable._venezuela};

    public static int[] IO =
            {R.drawable._african_union, R.drawable._antarctic_treaty_secretariat, R.drawable._arab_maghreb_union, R.drawable._asia_pacific_economic_cooperation, R.drawable._assembly_of_european_regions, R.drawable._association_of_southeast_asian_nations,
                    R.drawable._bolivarian_alliance_for_the_peoples_of_our_america, R.drawable._caribbean_community, R.drawable._central_american_integration_system, R.drawable._cocos_islands, R.drawable._collective_security_treaty_organization, R.drawable._commonwealth_of_independent_states, R.drawable._council_of_europe,
                    R.drawable._council_of_the_baltic_sea_states, R.drawable._democratic_republic_of_the_congo, R.drawable._east_african_community, R.drawable._economic_cooperation_organization, R.drawable._eureka, R.drawable._european_free_trade_association, R.drawable._european_organisation_for_the_safety_of_air_navigation,
                    R.drawable._european_organization_for_nuclear_research, R.drawable._european_southern_observatory, R.drawable._european_space_agency, R.drawable._falkland_islands, R.drawable._french_southern_territories, R.drawable._global_environment_facility, R.drawable._guadeloupe, R.drawable._indian_ocean_commission,
                    R.drawable._intergovernmental_authority_on_development, R.drawable._international_atomic_energy_agency, R.drawable._international_union_for_conservation_of_nature, R.drawable._martinique, R.drawable._mayotte, R.drawable._micronesia, R.drawable._nordic_council, R.drawable._north_atlantic_treaty_organization,
                    R.drawable._organization_of_american_states, R.drawable._pacific_islands_forum, R.drawable._partnerships_in_environmental_management_for_the_seas_of_east_asia, R.drawable._republic_of_china, R.drawable._secretariat_of_the_pacific_community, R.drawable._south_atlantic_peace_and_cooperation_zone,
                    R.drawable._south_georgia_and_the_south_sandwich_islands, R.drawable._southern_african_development_community, R.drawable._svalbard_and_jan_mayen, R.drawable._union_of_south_american_nations, R.drawable._united_nations, R.drawable._ussr, R.drawable._western_european_union, R.drawable._world_association_of_nuclear_operators};

    public static int[] Muslims = {R.drawable._indonesia, R.drawable._pakistan, R.drawable._india, R.drawable._bangladesh, R.drawable._nigeria, R.drawable._iran, R.drawable._turkey, R.drawable._egypt, R.drawable._algeria, R.drawable._morocco, R.drawable._iraq, R.drawable._sudan, R.drawable._afghanistan,
            R.drawable._ethiopia, R.drawable._uzbekistan, R.drawable._saudi_arabia, R.drawable._yemen, R.drawable._china, R.drawable._syria, R.drawable._malaysia, R.drawable._burkina_faso, R.drawable._mali, R.drawable._senegal, R.drawable._tunisia, R.drawable._guinea, R.drawable._somalia, R.drawable._azerbaijan, R.drawable._tajikistan, R.drawable._sierra_leone, R.drawable._libya,
            R.drawable._jordan, R.drawable._united_arab_emirates, R.drawable._kyrgyzstan, R.drawable._turkmenistan, R.drawable._chad, R.drawable._lebanon, R.drawable._kuwait, R.drawable._albania, R.drawable._mauritania, R.drawable._oman, R.drawable._kosovo, R.drawable._gambia, R.drawable._bahrain, R.drawable._comoros, R.drawable._qatar, R.drawable._djibouti, R.drawable._brunei, R.drawable._maldives};

    //ashmore   coralsea netherlandanti   bassas cliper europa ıland , glorios , Juan de nava , tromelin  jan mayen. baker  howland  jarvis

    //johnson kingmAN midway navasa palmyra  wake
    public static int[] Territories = {R.drawable._christmas_island, R.drawable._cocos_islands, R.drawable._heard_island_and_mcdonald_islands, R.drawable._norfolk_island, R.drawable._faroe_islands, R.drawable._greenland, R.drawable._aruba, R.drawable._french_guiana, R.drawable._french_polynesia, R.drawable._french_southern_territories,
            R.drawable._guadeloupe, R.drawable._martinique, R.drawable._mayotte, R.drawable._new_caledonia, R.drawable._reunion, R.drawable._saint_pierre_and_miquelon, R.drawable._wallis_and_futuna, R.drawable._cook_islands, R.drawable._niue, R.drawable._tokelau, R.drawable._bouvet_island,R.drawable._svalbard_and_jan_mayen, R.drawable._svalbard_and_jan_mayen, R.drawable._anguilla,
            R.drawable._bermuda, R.drawable._british_indian_ocean_territory, R.drawable._virgin_islands_british, R.drawable._cayman_islands, R.drawable._falkland_islands, R.drawable._gibraltar, R.drawable._guernsey, R.drawable._jersey, R.drawable._isle_of_man, R.drawable._montserrat, R.drawable._pitcairn_islands, R.drawable._saint_helena, R.drawable._south_georgia_and_the_south_sandwich_islands,
            R.drawable._turks_and_caicos_islands, R.drawable._samoa, R.drawable._guam, R.drawable._northern_mariana_islands, R.drawable._puerto_rico, R.drawable._virgin_islands_british};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    //ArrayList<Flag> AfricanCountriesIds ;

    public void getAllCountriesFlags() {

        for (int i = 0; i < Africa.length; i++)
            FlagIds.add(Africa[i]);

        for (int i = 0; i < Europe.length; i++)
            FlagIds.add(Flags.Europe[i]);

        for (int i = 0; i < Asia.length; i++)
            FlagIds.add(Asia[i]);

        for (int i = 0; i < NAmerica.length; i++)
            FlagIds.add(NAmerica[i]);

        for (int i = 0; i < SAmerica.length; i++)
            FlagIds.add(SAmerica[i]);

        for (int i = 0; i < Oceana.length; i++)
            FlagIds.add(Oceana[i]);


    }


}
