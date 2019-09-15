
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

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

        get("/squad",((request, response) -> {
            Map<String,Object>model=new HashMap<>();
            return new ModelAndView(model, "Squad.hbs");
        }), new HandlebarsTemplateEngine());

        get("/Slist",((request, response) -> {
            Map<String,Object>model=new HashMap<>();
            return new ModelAndView(model, "Alsquad.hbs");
        }), new HandlebarsTemplateEngine());

        get("/Hlist",((request, response) -> {
            Map<String,Object>model=new HashMap<>();
            return new ModelAndView(model, "AlHero.hbs");
        }), new HandlebarsTemplateEngine());
    }
}
