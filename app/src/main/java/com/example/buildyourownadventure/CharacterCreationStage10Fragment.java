package com.example.buildyourownadventure;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharacterCreationStage10Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterCreationStage10Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private Character c;

    public CharacterCreationStage10Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment CharacterCreationStage10Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CharacterCreationStage10Fragment newInstance(Character c) {
        CharacterCreationStage10Fragment fragment = new CharacterCreationStage10Fragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, c);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            c = (Character) getArguments().getSerializable(ARG_PARAM1);
        }
    }
    Button back;
    Button createCharacter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character_creation_stage10, container, false);
        back = view.findViewById(R.id.buttonBackStage10);
        createCharacter = view.findViewById(R.id.buttonCreateStage10);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCharacterStage10Listener.backFromStage10();
            }
        });


        createCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //FIRE BASE STUFF//
                //makes fire base instance //
                FirebaseFirestore db = FirebaseFirestore.getInstance();

                //gets authentification instance so i cant get the users id//
                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                c.userId = mAuth.getCurrentUser().getUid();

                // Determine what data will be shown in each character instance in firebase //
                //Made three makes one for string, one fore 2d string array, one fore integer //
                Map<String, String> character = new HashMap<>();
                Map<String, String[]> character2 = new HashMap<>();
                Map<String, Integer> character3 = new HashMap<>();


                character.put("Userid", c.getUserId());
                character.put("name", c.getName());
                character.put("class", c.getCharacterClass());
                character.put("background", c.getBackground());
                character.put("race", c.getRace());
                character.put("subRace", c.getSubRace());
                character.put("alignment", c.getAlignment());
                character.put("hitDice", c.getHitDice());
                character2.put("skills", c.getSkills());
                character.put("personalityTraits", c.getPersonalityTraits());
                character.put("ideals", c.getIdeals());
                character.put("bonds", c.getBonds());
                character.put("flaws", c.getFlaws());
                character.put("biography", c.getBio());
                character3.put("level", c.getLevel());
                character3.put("experiencePoints", c.getExperiencePoints());
                character3.put("inspiration", c.getInspiration());
                character3.put("proficiencyBonus", c.getProficiencyBonus());
                character3.put("passiveWisdom", c.getPassiveWisdom());
                character3.put("armorClass", c.getArmorClass());
                character3.put("initiative", c.getInitiative());
                character3.put("speed", c.getSpeed());
                character3.put("currentHitPoints", c.getCurrentHitPoints());
                character3.put("tempHitPoints", c.getTempHitPoints());
                character3.put("bardicInspiration", c.getBardicInspiration());
                character3.put("otherResource", c.getOtherResource());

                character3.put("strength", c.getStrength());
                character3.put("ASMStrength", c.getASMStrength());
                character3.put("dexterity", c.getDexterity());
                character3.put("ASMDexterity", c.getASMDexterity());
                character3.put("constitution", c.getConstitution());
                character3.put("ASMConstitution", c.getASMConstitution());
                character3.put("intelligence", c.getIntelligence());
                character3.put("ASMIntelligence", c.getASMIntelligence());
                character3.put("wisdom", c.getWisdom());
                character3.put("ASMWisdom", c.getASMWisdom());
                character3.put("charisma", c.getCharisma());
                character3.put("ASMCharisma", c.getASMCharisma());
                character3.put("copper", c.getCopper());
                character3.put("silver", c.getSilver());
                character3.put("electrum", c.getElectrum());
                character3.put("gold", c.getGold());
                character3.put("platinum", c.getPlatinum());


                character3.put("AttributeStrength", c.getAttributeStrength());
                character3.put("AttributeDexterity", c.getAttributeDexterity());
                character3.put("AttributeConstitution", c.getAttributeConstitution());
                character3.put("AttributeIntelligence", c.getAttributeIntelligence());
                character3.put("AttributeWisdom", c.getAttributeWisdom());
                character3.put("AttributeCharisma", c.getAttributeCharisma());
                character3.put("AttributeAcrobatics", c.getAttributeAcrobatics());
                character3.put("AttributeAnimalHandling", c.getAttributeAnimalHandling());
                character3.put("AttributeArcana", c.getAttributeArcana());
                character3.put("AttributeAthletics", c.getAttributeAthletics());
                character3.put("AttributeDeception", c.getAttributeDeception());
                character3.put("AttributeHistory", c.getAttributeHistory());
                character3.put("AttributeInsight", c.getAttributeInsight());
                character3.put("AttributeIntimidation", c.getAttributeIntimidation());
                character3.put("AttributeInvestigation", c.getAttributeInvestigation());
                character3.put("AttributeMedicine", c.getAttributeMedicine());
                character3.put("AttributeNature", c.getAttributeNature());
                character3.put("AttributePerception", c.getAttributePerception());
                character3.put("AttributePerformance", c.getAttributePerformance());
                character3.put("AttributePersuasion", c.getAttributePersuasion());
                character3.put("AttributeReligion", c.getAttributeReligion());
                character3.put("AttributeSleightOfHand", c.getAttributeSleightOfHand());
                character3.put("AttributeStealth", c.getAttributeStealth());
                character3.put("AttributeSurvival", c.getAttributeSurvival());
                character3.put("failures", c.getFailures());
                character3.put("successes", c.getSuccesses());






                db.collection("characters").document(c.getName())
                        .set(character);

                //FIRE BASE STUFF//



                CreateCharacterStage10Listener.createCharacter(c);
            }
        });




        return view;
    }

    ICreateCharacterStage10Listener CreateCharacterStage10Listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ICreateCharacterStage10Listener) {
            CreateCharacterStage10Listener = (ICreateCharacterStage10Listener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement ICreateCharacterStage1Listener");
        }
    }

    public interface ICreateCharacterStage10Listener{
        void backFromStage10();
        void createCharacter(Character c);
    }
}