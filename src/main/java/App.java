
import models.Hero;
import org.graalvm.compiler.core.match.MatchGenerator;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args){
//        staticFileLocation("/public");
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
            Hero newHero =new Hero(name);
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

        get("/Slist",((request, response) -> {
            Map<String,Object>model=new HashMap<>();
            return new ModelAndView(model, "Alsquad.hbs");
        }), new HandlebarsTemplateEngine());


    }
}
