
import models.Hero;
import models.Squad;
import org.graalvm.compiler.core.match.MatchGenerator;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args){
        staticFileLocation("/public");
        get("/",((request, response) -> {
            Map<String,Object>model=new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }), new HandlebarsTemplateEngine());

        get("/heroes",((request, response) -> {
            Map<String,Object>model=new HashMap<>();
            return new ModelAndView(model, "Hero.hbs");
        }), new HandlebarsTemplateEngine());


        post("/heroes",((request, response) -> {
            Map<String,Object>model=new HashMap<>();
            String name= request.queryParams("name");
            int Age=Integer.parseInt(request.queryParams("age"));
            String weak= request.queryParams("weakness");
            String power= request.queryParams("SpecialPower");
            String league= request.queryParams("league");
            Hero newHero =new Hero(name,Age,weak,power,league);
            return new ModelAndView(model, "succesHero.hbs");
        }), new HandlebarsTemplateEngine());


        get("/Hlist",((request, response) -> {
            Map<String,Object>model=new HashMap<>();
            ArrayList<Hero>heros=Hero.All();
            model.put("heroes",heros);
            return new ModelAndView(model, "AlHero.hbs");
        }), new HandlebarsTemplateEngine());



        get("/hero/:heroId",((request, response) -> {
            Map<String,Object>model=new HashMap<>();
            int idOfHero=Integer.parseInt(request.params("heroId"));
            Hero findHero=Hero.findId(idOfHero);
            model.put("hero",findHero);
            return new ModelAndView(model, "Hero-details.hbs");
        }), new HandlebarsTemplateEngine());



        get("/squad",((request, response) -> {
            Map<String,Object>model=new HashMap<>();
            return new ModelAndView(model, "Squad.hbs");
        }), new HandlebarsTemplateEngine());

        post("/squad",((request, response) -> {
            Map<String,Object>model=new HashMap<>();
            String sName=request.queryParams("Sname");
//            int max=Integer.parseInt(request.params("maxsize"));
            String reason=request.queryParams("reason");
            Squad newSquad=new Squad(sName,reason);
            return new ModelAndView(model, "succesSquad.hbs");
        }), new HandlebarsTemplateEngine());

        get("/Slist",((request, response) -> {
            Map<String,Object>model=new HashMap<>();
            ArrayList<Squad> squads =Squad.getAll();
            model.put("squad1",squads);
            return new ModelAndView(model, "Alsquad.hbs");
        }), new HandlebarsTemplateEngine());

        get("/sq/:squadId",((request, response) -> {
            Map<String,Object>model=new HashMap<>();
            int idSquadToFind=Integer.parseInt(request.params("squadId"));
            Squad findsuad=Squad.findSquadId(idSquadToFind);
            model.put("suad",findsuad);
            return new ModelAndView(model, "Squad-Details.hbs");
        }), new HandlebarsTemplateEngine());
    }
}
