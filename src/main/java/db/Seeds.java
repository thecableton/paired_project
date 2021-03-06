package db;

import models.dinosaurs.Dinosaur;
import models.enums.DietaryType;
import models.enums.DinosaurType;
import models.information.Info;
import models.paddocks.Paddock;
import models.visitors.Visit;
import models.visitors.Visitor;

import java.util.List;

public class Seeds {

    public static void seedData() {
        DBHelper.deleteAll(Dinosaur.class);
        DBHelper.deleteAll(Paddock.class);
        DBHelper.deleteAll(Visit.class);
        DBHelper.deleteAll(Visitor.class);
        DBHelper.deleteAll(Info.class);



        Paddock funPaddock = new Paddock( "Test Paddock", DietaryType.CARNIVORE);
        DBHelper.save(funPaddock);

        Dinosaur bigDino = new Dinosaur(DinosaurType.GIGANOTOSAURUS);
        DBHelper.save(bigDino);
        DBDinosaur.addPaddockToDinosaur(bigDino, funPaddock);
        DBHelper.update(funPaddock);

        Paddock carnivorePaddock = new Paddock( "T-Rex paddock", DietaryType.CARNIVORE);
        DBHelper.save(carnivorePaddock);

        Paddock herbivorePaddock = new Paddock("Herbivores", DietaryType.HERBIVORE);
        DBHelper.save(herbivorePaddock);

        Paddock herbivorePaddock2 = new Paddock("Herbivore Park", DietaryType.HERBIVORE);
        DBHelper.save(herbivorePaddock2);

        Dinosaur carnivoreTRex = new Dinosaur(DinosaurType.TREX);
        DBHelper.save(carnivoreTRex);
        carnivoreTRex.setStomach(60);
        carnivoreTRex.assignHungerLevel();
        DBHelper.update(carnivoreTRex);
        DBDinosaur.addPaddockToDinosaur(carnivoreTRex, carnivorePaddock);
        DBHelper.update(carnivorePaddock);

        Dinosaur carnivoreTrex2 = new Dinosaur(DinosaurType.TREX);
        DBHelper.save(carnivorePaddock);
        DBDinosaur.addPaddockToDinosaur(carnivoreTRex, carnivorePaddock);

        Dinosaur herbivoreTriceratops = new Dinosaur(DinosaurType.TRICERATOPS);
        DBHelper.save(herbivoreTriceratops);
        DBDinosaur.addPaddockToDinosaur(herbivoreTriceratops, herbivorePaddock);
//
        DBHelper.update(herbivorePaddock);



        Dinosaur herbivoreBroDino = new Dinosaur(DinosaurType.BRACHIOSAURUS);
        DBHelper.save(herbivoreBroDino);
        DBDinosaur.addPaddockToDinosaur(herbivoreBroDino, herbivorePaddock);


        List<Paddock> herbivorePaddocksFound = DBDinosaur.getAllPaddocksByDietaryType(DietaryType.HERBIVORE);

        Visitor visitorMike = new Visitor("Mike", "Thorpe", "mikey", "mike@mike.com");
        DBHelper.save(visitorMike);

        double averageHunger = DBPaddock.getAverageStomachLevelByPaddock(herbivorePaddock);
        double averageStrength = DBPaddock.getAverageStrengthByPaddock(herbivorePaddock);
        carnivorePaddock.rampageCheck();
        herbivorePaddock.rampageCheck();

        Info infoTrex = new Info(DinosaurType.TREX);
        DBHelper.save(infoTrex);
        infoTrex.setText("The Tyrannosaurus rex was one of the largest of the land predator dinosaurs. The T-rex measured up to 43 feet long and weighed as much as 7.5 tons. The dinosaur is often used in movie and films such as Jurassic Park due to its size and overall fearsome image. ");
        DBHelper.update(infoTrex);
        Info infoTrex2 = new Info(DinosaurType.TREX);
        DBHelper.save(infoTrex2);
        infoTrex2.setText("The Tyrannosaurus had a life span of around 30 years.");
        DBHelper.update(infoTrex2);
        Info infoTrex3 = new Info(DinosaurType.TREX);
        DBHelper.save(infoTrex3);
        infoTrex3.setText("The Tyrannosaurus' arms were too short to reach its mouth.");
        DBHelper.update(infoTrex3);

        Info infoGiganotosaurus = new Info(DinosaurType.GIGANOTOSAURUS);
        DBHelper.save(infoGiganotosaurus);
        infoGiganotosaurus.setText("This is one of the biggest meat eating dinosaur that ever lived. Even bigger than the dinosaur T Rex - but a little bit smaller than the Spinosaurus. Despite its size it had a tiny brain! About the size of a small cucumber. ");
        DBHelper.update(infoGiganotosaurus);
        Info infoGiganotosaurus2 = new Info(DinosaurType.GIGANOTOSAURUS);
        DBHelper.save(infoGiganotosaurus2);
        infoGiganotosaurus2.setText("They are considered to be one of the largest meat eating dinosaur. The bigger males would have weighed over 13 tons. It is estimated that their skulls would have been 6.40 ft in length.");
        DBHelper.update(infoGiganotosaurus2);

        Info infoVelociraptor = new Info(DinosaurType.VELOCIRAPTOR);
        DBHelper.save(infoVelociraptor);
        infoVelociraptor.setText("A fully grown Velociraptor could grow up to 2m (6.6ft) in length, 0.5m (1.6ft) in height at the hip and weigh up to 15kg (33lb). It kills its prey with sickle shaped claws on its rear feet.");
        DBHelper.update(infoVelociraptor);
        Info infoPterosaur = new Info(DinosaurType.PTEROSAUR);
        DBHelper.save(infoPterosaur);
        infoPterosaur.setText("Pterosaur ranged in size from Just a few centimetres to more than 12 metres, mostly feeding on fish while some scavenged dead animals and ate insects inland.");
        DBHelper.update(infoPterosaur);
        Info infoPterosaur2 = new Info(DinosaurType.PTEROSAUR);
        DBHelper.save(infoPterosaur2);
        infoPterosaur2.setText("The wing of the pterosaur was unique, a large membrane suspended from a hugely expanded fourth finger. Pterosaurs are largely regarded as the first vertebrates to achieve sustainable powered flight, although the largest relied mainly on the wind and gliding to stay in the air.");
        DBHelper.update(infoPterosaur2);

        Info infoTriceratops = new Info(DinosaurType.TRICERATOPS);
        DBHelper.save(infoTriceratops);
        infoTriceratops.setText("To defend itself against meat eaters (predators) it had two long brow horns. These could grow to be at least 1 metre (3 feet) long. Triceratops would have been able to cause a lot of damage to an attacker!");
        DBHelper.update(infoTriceratops);


        Info infoTriceratops2 = new Info(DinosaurType.TRICERATOPS);
        DBHelper.save(infoTriceratops2);
        infoTriceratops2.setText("The Triceratops had rows and rows of teeth as well as a sharp hard beak, allowing them to slice and crush all sorts of vegetation. Despite their fearsome appearance, they didn't kill other dinosaurs for meat, but they likely would have defended themselves well from predators. It is thought that the triceratops were herding animals and that they wandered the plains on all fours in large herds eating plants as they went. Sort of like buffalo or cows do today.");
        DBHelper.update(infoTriceratops2);


        Info infoStegosaurus = new Info(DinosaurType.STEGOSAURUS);
        DBHelper.save(infoStegosaurus);
        infoStegosaurus.setText("In terms of size, the Stegosaurus was large and heavily built. On average, a fully grown Stegosaurus was around 9 metres (30ft) in length, 4 metres (14ft) in height and up to nearly 5 metric tons in weight.");
        DBHelper.update(infoStegosaurus);

        Info infoStegosaurus2 = new Info(DinosaurType.STEGOSAURUS);
        DBHelper.save(infoStegosaurus2);
        infoStegosaurus2.setText("The 17 plates found along the back of the Stegosaurus arose from the skin rather than being attached to the skeleton. The largest plates were around 60cm (2ft) tall and 60cm (2ft) wide.");
        DBHelper.update(infoStegosaurus2);




        Info infoSpinosaurus = new Info(DinosaurType.SPINOSAURUS);
        DBHelper.save(infoSpinosaurus);
        infoSpinosaurus.setText("The Spinosaurus was larger than the Tyrannosaurus Rex and may have been the largest carnivorous (meat eating) dinosaur ever.");
        DBHelper.update(infoSpinosaurus);

        Info infoSpinosaurus2 = new Info(DinosaurType.SPINOSAURUS);
        DBHelper.save(infoSpinosaurus2);
        infoSpinosaurus.setText("The Spinosaurus featured distinctive spines which grew over 1.5 metres (5 feet) long.");
        DBHelper.update(infoSpinosaurus2);



        Info infoBrachiosaurus = new Info(DinosaurType.BRACHIOSAURUS);
        DBHelper.save(infoBrachiosaurus);
        infoBrachiosaurus.setText("An adult Brachiosaurus was unlikely to have had any predators due to its large size. However, a young brachiosaurus would have been a target for the large carnivores present at the time, such as Allosaurus.");
        DBHelper.update(infoBrachiosaurus);


        carnivorePaddock.setAccessibleToVisitors(true);
        DBHelper.update(carnivorePaddock);
        herbivorePaddock.setAccessibleToVisitors(true);
        DBHelper.update(herbivorePaddock);
        Visit visit = new Visit(visitorMike);
        DBHelper.save(visit);



        List<Dinosaur> allDino = DBDinosaur.getAllDinoForPaddock(carnivorePaddock);

        Visitor foundVisitor = DBVisitor.findVisitorByUsername("mikey");
        boolean visitorExistence = DBVisitor.checkIfVisitorByUsernameExists("mikey");
        boolean visitorExistenceFalse = DBVisitor.checkIfVisitorByUsernameExists("jolo");

        visit.passageOfTime();
        visit.passageOfTime();
        visit.passageOfTime();
        visit.passageOfTime();
        visit.passageOfTime();
        visit.passageOfTime();
        visit.passageOfTime();
        visit.passageOfTime();
        List<Paddock> allowedToVisit = DBPaddock.filterByCanVisit();
        List<Paddock> shuffledPaddocksForVisit = visit.getPaddocks();




        List<Paddock> allPaddocks = DBHelper.getAll(Paddock.class);
        List<Paddock> allPaddocksForVisit = DBVisit.getAllPaddocksForVisit(visit);
        Info randomInfoOnSpecies = Info.getRandomInfoOfSpecies(DinosaurType.TREX);
        Info randomInfoOnHerbivore = Info.getRandomInfoOnHerbivore();
//        Visit recentVisit = DBVisit.getMostRecentVisit(visitorMike);



    }
}
