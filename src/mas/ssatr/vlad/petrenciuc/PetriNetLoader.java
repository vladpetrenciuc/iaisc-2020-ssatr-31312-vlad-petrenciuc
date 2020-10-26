package mas.ssatr.vlad.petrenciuc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PetriNetLoader {
    public ArrayList<Place> places = new ArrayList<>();
    public ArrayList<Transition> transitions = new ArrayList<>();

    public PetriNetLoader() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/mas/ssatr/vlad/petrenciuc/petri.json"));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonPlaces = (JSONArray) jsonObject.get("places");
            JSONArray jsonTransitions = (JSONArray) jsonObject.get("transitions");

            for (int i = 0; i < jsonPlaces.size(); i++) {
                JSONObject jsonObj = (JSONObject) jsonPlaces.get(i);
                Place aux = new Place((String) jsonObj.get("name"), Integer.parseInt(jsonObj.get("tokens").toString()),
                        Integer.parseInt(jsonObj.get("min_time").toString()), Integer.parseInt(jsonObj.get("max_time").toString()));
                places.add(aux);
            }

            for (Object jsonTransition : jsonTransitions) {
                JSONObject jsonObj = (JSONObject) jsonTransition;

                String name = (String) jsonObj.get("name");
                ArrayList<String> inp = (ArrayList<String>) jsonObj.get("inputs");
                ArrayList<String> out = (ArrayList<String>) jsonObj.get("outputs");
                ArrayList<Place> tmp_in = new ArrayList<>();
                ArrayList<Place> tmp_out = new ArrayList<>();

                String time = jsonObj.get("time").toString();

                for (int j = 0; j < inp.size(); j++) {
                    for (Place p : places) {
                        if (p.name.equals((String) inp.get(j))) {
                            tmp_in.add(p);
                            break;
                        }
                    }
                }

                for (int j = 0; j < out.size(); j++) {
                    for (Place p : places) {
                        if (p.name.equals((String) out.get(j))) {
                            tmp_out.add(p);
                            break;
                        }
                    }
                }

                Transition aux = new Transition(name, tmp_in, tmp_out, Integer.parseInt(time));
                transitions.add(aux);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
