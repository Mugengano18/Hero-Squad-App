
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
        //this is the path to the home page
        get("/",((request, response) -> {
            Map<String,Object>model=new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }), new HandlebarsTemplateEngine());

        //this brings you to the hero form
        get("/heroes",((request, response) -> {
            Map<String,Object>model=new HashMap<>();
            return new ModelAndView(model, "Hero.hbs");
        }), new HandlebarsTemplateEngine());


        //we are going to get our hero from the form and post
        post("/heroes",((request, response) -> {
            Map<String,Object>model=new HashMap<>();
            String name= request.queryParams("name");
            int Age=Integer.parseInt(request.queryParams("age"));
            String weak= request.queryParams("weakness");
            String power= request.queryParams("power");
            String league= request.queryParams("squad");
            Hero newHero =new Hero(name,Age,weak,power,league);
            model.put("Name",newHero.getName());
            model.put("Age",newHero.getAge());
            model.put("Weakness",newHero.getWeakness());
            model.put("Power",newHero.getSpecialPower());
            model.put("Squad",newHero.getLeague());
            model.put("heroe",newHero);
            System.out.println(power);
            System.out.println(newHero.getSpecialPower());
            return new ModelAndView(model, "succesHero.hbs");
        }), new HandlebarsTemplateEngine());


        //this page shows that you have successfully created the hero
        get("/Hlist",((request, response) -> {
            Map<String,Object>model=new HashMap<>();
            ArrayList<Hero>heros=Hero.All();
            model.put("heroes",heros);
            return new ModelAndView(model, "AlHero.hbs");
        }), new HandlebarsTemplateEngine());



        //this show you the hero informations depending on the id
        get("/hero/:heroId",((request, response) -> {
            Map<String,Object>model=new HashMap<>();
            int idOfHero=Integer.parseInt(request.params("heroId"));
            Hero findHero=Hero.findId(idOfHero);
            model.put("hero",findHero);
            return new ModelAndView(model, "Hero-details.hbs");
        }), new HandlebarsTemplateEngine());



        //we are going to delete our hero
        get("/hero/:heroId/del",((request, response) -> {
            Map<String,Object>model=new HashMap<>();
            int idOfHeToDel=Integer.parseInt(request.params("heroId"));
            Hero deleteHero=Hero.findId(idOfHeToDel);
            deleteHero.delHero();
            return new ModelAndView(model, "del.hbs");
        }), new HandlebarsTemplateEngine());




        //updating our hero
        get("/hero/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfheroToEdit = Integer.parseInt(request.params("heroId"));
            Hero edith = Hero.findId(idOfheroToEdit);
            model.put("edithero", edith);
            return new ModelAndView(model, "Hero.hbs");
        }, new HandlebarsTemplateEngine());



        //this path shows the squad form
        get("/squad",((request, response) -> {
            Map<String,Object>model=new HashMap<>();
            return new ModelAndView(model, "Squad.hbs");
        }), new HandlebarsTemplateEngine());


        //this shows the list of information of the squad
        post("/squad2",((request, response) -> {
                Map<String,Object>model=new HashMap<>();
                String Sname= request.queryParams("name");
                int maxsize=Integer.parseInt(request.queryParams("number"));
                String reason= request.queryParams("fight");
            Squad newHero =new Squad(Sname,maxsize,reason);
            model.put("name",newHero.getSname());
            model.put("number",newHero.getMaxsize());
            model.put("fight",newHero.getReason());
            return new ModelAndView(model, "succesSquad.hbs");
        }), new HandlebarsTemplateEngine());





//        get("/Slist",((request, response) -> {
//            Map<String,Object>model=new HashMap<>();
//            ArrayList<Squad> squads =Squad.All();
//            model.put("squad",squads);
//            return new ModelAndView(model, "Alsquad.hbs");
//        }), new HandlebarsTemplateEngine());



//        get("/sq/:squadId",((request, response) -> {
//            Map<String,Object>model=new HashMap<>();
//            int idSquadToFind=Integer.parseInt(request.params("squadId"));
//            Squad findsuad=Squad.findId(idSquadToFind);
//            model.put("suad",findsuad);
//            return new ModelAndView(model, "Squad-Details.hbs");
//        }), new HandlebarsTemplateEngine());
    }
}
