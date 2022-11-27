package com.gotovchykov.view;

import com.gotovchykov.controller.*;
import com.gotovchykov.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MyView {

    @Autowired
    private AirlineControler airlineControler;
    @Autowired
    private AirportControler airportControler;
    @Autowired
    private BaggageControler baggageControler;
    @Autowired
    private BuyingHistoryControler buyingHistoryControler;
    @Autowired
    private FlightInfoControler flightInfoControler;
    @Autowired
    private FlightTicketControler flightTicketControler;
    @Autowired
    private UserProfileControler userProfileControler;

    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner input = new Scanner(System.in);
    private final Airline nullAirline = new Airline(null, null);
    private final Airport nullAirport = new Airport(null, null, null, null, null);
    private final Baggage nullBaggage = new Baggage(null, null, null, null, null);
    private final BuyingHistory nullBuyingHistory = new BuyingHistory (null, null, null);
    private final FlightInfo nullFlightInfo = new FlightInfo(null, null, null, null, null, null);
    private final FlightTicket nullFlightTicket = new FlightTicket(null, null, null, null, null, null, null);
    private final UserProfile nullUserProfile = new UserProfile(null, null, null, null, null);
   

    public MyView() {
        menu = new LinkedHashMap<>();
        menu.put("A", "  A - Select all table");

        menu.put("1", "   1 - Table: Airline");//
        menu.put("11", "  11 - Create Airline");
        menu.put("12", "  12 - Update Airline");
        menu.put("13", "  13 - Delete from Airline");
        menu.put("14", "  14 - Find all Airline");
        menu.put("15", "  15 - Find Airline by ID");

        menu.put("2", "   2 - Table: Airport");//
        menu.put("21", "  21 - Create Airport");
        menu.put("22", "  22 - Update Airport");
        menu.put("23", "  23 - Delete from Airport");
        menu.put("24", "  24 - Find all Airport");
        menu.put("25", "  25 - Find Airport by ID");

        menu.put("3", "   3 - Table: Baggage");
        menu.put("31", "  31 - Create Baggage");
        menu.put("32", "  32 - Update Baggage");
        menu.put("33", "  33 - Delete from Baggage");
        menu.put("34", "  34 - Find all Baggage");
        menu.put("35", "  35 - Find Baggage by ID");


        menu.put("4", "   4 - Table:BuyingHistory ");//
        menu.put("41", "  41 - Create BuyingHistory");
        menu.put("42", "  42 - Update BuyingHistory");
        menu.put("43", "  43 - Delete from BuyingHistory");
        menu.put("44", "  44 - Find all BuyingHistory");
        menu.put("45", "  45 - Find BuyingHistory by ID");

        menu.put("5", "   5 - Table: FlightInfo");//
        menu.put("51", "  51 - Create FlightInfo");
        menu.put("52", "  52 - Update FlightInfo");
        menu.put("53", "  53 - Delete from FlightInfo");
        menu.put("54", "  54 - Find all FlightInfo");
        menu.put("55", "  55 - Find FlightInfo by ID");

        menu.put("6", "   6 - Table: FlightTicket");//
        menu.put("61", "  61 - Create FlightTicket");
        menu.put("62", "  62 - Update FlightTicket");
        menu.put("63", "  63 - Delete from FlightTicket");
        menu.put("64", "  64 - Find all FlightTicket");
        menu.put("65", "  65 - Find FlightTicket by ID");

        menu.put("7", "   7 - Table: UserProfile");//
        menu.put("71", "  71 - Create UserProfile");
        menu.put("72", "  72 - Update UserProfile");
        menu.put("73", "  73 - Delete from UserProfile");
        menu.put("74", "  74 - Find all UserProfile");
        menu.put("75", "  75 - Find UserProfile by ID");


        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("A", this::selectAllTable);

        methodsMenu.put("11", this::createAirline);
        methodsMenu.put("12", this::updateAirline);
        methodsMenu.put("13", this::deleteFromAirline);
        methodsMenu.put("14", this::findAllAirlines);
        methodsMenu.put("15", this::findAirlineById);

        methodsMenu.put("21", this::createAirport);
        methodsMenu.put("22", this::updateAirport);
        methodsMenu.put("23", this::deleteFromAirport);
        methodsMenu.put("24", this::findAllAirports);
        methodsMenu.put("25", this::findAirportById);

        methodsMenu.put("31", this::createBaggage);
        methodsMenu.put("32", this::updateBaggage);
        methodsMenu.put("33", this::deleteFromBaggage);
        methodsMenu.put("34", this::findAllBaggages);
        methodsMenu.put("35", this::findBaggageById);

        methodsMenu.put("41", this::createBuyingHistory);
        methodsMenu.put("42", this::updateBuyingHistory);
        methodsMenu.put("43", this::deleteFromBuyingHistory);
        methodsMenu.put("44", this::findAllBuyingHistorys);
        methodsMenu.put("45", this::findBuyingHistoryById);

        methodsMenu.put("51", this::createFlightInfo);
        methodsMenu.put("52", this::updateFlightInfo);
        methodsMenu.put("53", this::deleteFromFlightInfo);
        methodsMenu.put("54", this::findAllFlightInfos);
        methodsMenu.put("55", this::findFlightInfoById);

        methodsMenu.put("61", this::createFlightTicket);
        methodsMenu.put("62", this::updateFlightTicket);
        methodsMenu.put("63", this::deleteFromFlightTicket);
        methodsMenu.put("64", this::findAllFlightTickets);
        methodsMenu.put("65", this::findFlightTicketById);

        methodsMenu.put("71", this::createUserProfile);
        methodsMenu.put("72", this::updateUserProfile);
        methodsMenu.put("73", this::deleteFromUserProfile);
        methodsMenu.put("74", this::findAllUserProfiles);
        methodsMenu.put("75", this::findUserProfileById);


    }

    private void selectAllTable() {
        findAllAirlines();
        findAllAirports();
        findAllBaggages();
        findAllBuyingHistorys();
        findAllFlightInfos();
        findAllFlightTickets();
        findAllUserProfiles();
    }


    //endregion
    // region CITY ---------------------------------------------------
    private void createAirline() {
    	System.out.println("Input 'FlightInfo_id': ");
        Integer airlineId = Integer.valueOf(input.nextLine());
        System.out.println("Input 'airline_name': ");
        String airlineName = input.nextLine();

        Airline airline = new Airline(airlineId, airlineName);

        int count = airlineControler.create(airline);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateAirline() {
        System.out.println("Input 'Airline_id': ");
        Integer airlineId = Integer.valueOf(input.nextLine());

        System.out.println("Input 'new_FlightInfo_name': ");
        String newAirlineName = input.nextLine();


        Airline airline = new Airline(airlineId, newAirlineName);

        int count = airlineControler.update(airlineId, airline);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromAirline() {
        System.out.println("Input 'Airline_id': ");
        Integer airlineId = Integer.valueOf(input.nextLine());

        int count =  airlineControler.delete(airlineId);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllAirlines() {
        System.out.println("\nTable: Airline");
        List<Airline> airlines = airlineControler.findAll();
        for (Airline airline : airlines) {
            System.out.println(airline);
        }
    }

    private void findAirlineById() {
        System.out.println("Input 'Airline_id': ");
        Integer airlineId = Integer.valueOf(input.nextLine());

        Optional<Airline> airline = airlineControler.findById(airlineId);
        System.out.println(airline.orElse(nullAirline));
    }

 
 // region CITY ---------------------------------------------------
    private void createBaggage() {
    	System.out.println("Input 'baggage_id': ");
        Integer baggageId = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'baggage_Type': ");
        String baggageType = input.nextLine();
        
        System.out.println("Input 'baggage_Height': ");
        Float baggageHeight = Float.valueOf(input.nextLine());
        
        System.out.println("Input 'baggage_Width': ");
        Float baggageWidth = Float.valueOf(input.nextLine());
        
        System.out.println("Input 'baggage_Weight': ");
        Float baggageWeight = Float.valueOf(input.nextLine());

        Baggage baggage = new Baggage(baggageId, baggageType, baggageHeight, baggageWidth, baggageWeight );

        int count = baggageControler.create(baggage);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateBaggage() {
    	System.out.println("Input 'baggage_id': ");
        Integer baggageId = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'baggage_Type': ");
        String baggageType = input.nextLine();
        
        System.out.println("Input 'baggage_Height': ");
        Float baggageHeight = Float.valueOf(input.nextLine());
        
        System.out.println("Input 'baggage_Width': ");
        Float baggageWidth = Float.valueOf(input.nextLine());
        
        System.out.println("Input 'baggage_Weight': ");
        Float baggageWeight = Float.valueOf(input.nextLine());

        Baggage baggage = new Baggage(baggageId, baggageType, baggageHeight, baggageWidth, baggageWeight );


        int count = baggageControler.update(baggageId, baggage);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromBaggage() {
        System.out.println("Input 'Airline_id': ");
        Integer baggageId = Integer.valueOf(input.nextLine());

        int count =  baggageControler.delete(baggageId);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllBaggages() {
        System.out.println("\nTable: Airline");
        List<Baggage> baggages = baggageControler.findAll();
        for (Baggage baggage : baggages) {
            System.out.println(baggage);
        }
    }

    private void findBaggageById() {
        System.out.println("Input 'Airline_id': ");
        Integer baggageId = Integer.valueOf(input.nextLine());

        Optional<Baggage> baggage = baggageControler.findById(baggageId);
        System.out.println(baggage.orElse(nullBaggage));
    }

    
    
    
    //endregion
    // region FlightInfo ---------------------------------------------------
    private void createFlightInfo() {
        System.out.println("Input 'FlightInfo_id': ");
        Integer flightInfoId = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'Airline_id': ");
        Integer airlineId = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'Airport_id': ");
        Integer airportId = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'Baggage_id': ");
        Integer baggageId = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'Date': ");
        String date = input.nextLine();
        
        System.out.println("Input 'Time': ");
        String time = input.nextLine();

        FlightInfo flightInfo = new FlightInfo(flightInfoId, airlineId, airportId, baggageId, date, time);

        int count = flightInfoControler.create(flightInfo);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateFlightInfo() {
    	System.out.println("Input 'FlightInfo_id': ");
        Integer flightInfoId = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'Airline_id': ");
        Integer airlineId = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'Airport_id': ");
        Integer airportId = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'Baggage_id': ");
        Integer baggageId = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'Date': ");
        String date = input.nextLine();
        
        System.out.println("Input 'Time': ");
        String time = input.nextLine();


        FlightInfo flightInfo = new FlightInfo(flightInfoId, airlineId, airportId, baggageId, date, time);

        int count = flightInfoControler.update(flightInfoId, flightInfo);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromFlightInfo() {
        System.out.println("Input 'FlightInfo_id': ");
        Integer flightInfoId = Integer.valueOf(input.nextLine());

        int count = flightInfoControler.delete(flightInfoId);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllFlightInfos() {
        System.out.println("\nTable: FlightInfo");
        List<FlightInfo> flightInfos = flightInfoControler.findAll();
        for (FlightInfo flightInfo : flightInfos) {
            System.out.println(flightInfo);
        }
    }

    private void findFlightInfoById() {
        System.out.println("Input 'FlightInfo_id': ");
        Integer flightInfoId = Integer.valueOf(input.nextLine());

        Optional<FlightInfo> flightInfo = flightInfoControler.findById(flightInfoId);
        System.out.println(flightInfo.orElse(nullFlightInfo));
    }


    //endregion
    // region BuyingHistory ---------------------------------------------------
    private void createBuyingHistory() {
        System.out.println("Input 'BuyingHistory_id': ");
        Integer buyingHistoryId = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'Date': ");
        String buyingHistoryDate = input.nextLine();
        
        System.out.println("Input 'User_Profile_Id': ");
        Integer userProfileId = Integer.valueOf(input.nextLine());
        
    

        BuyingHistory buyingHistory = new BuyingHistory(buyingHistoryId, buyingHistoryDate, userProfileId);

        int count = buyingHistoryControler.create(buyingHistory);
        System.out.printf("There are created %d rows\n", count);
    }


    private void updateBuyingHistory() {
    	System.out.println("Input 'BuyingHistory_id': ");
        Integer buyingHistoryId = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'Date': ");
        String buyingHistoryDate = input.nextLine();
        
        System.out.println("Input 'User_Profile_Id': ");
        Integer userProfileId = Integer.valueOf(input.nextLine());
        
    

        BuyingHistory buyingHistory = new BuyingHistory(buyingHistoryId, buyingHistoryDate, userProfileId);

        int count = buyingHistoryControler.update(buyingHistoryId, buyingHistory);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromBuyingHistory() {
        System.out.println("Input 'BuyingHistoryId': ");
        Integer buyingHistoryId = Integer.valueOf(input.nextLine());

        int count = buyingHistoryControler.delete(buyingHistoryId);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllBuyingHistorys() {
        System.out.println("\nTable: BuyingHistory");
        List<BuyingHistory> buyingHistorys = buyingHistoryControler.findAll();
        for (BuyingHistory buyingHistory : buyingHistorys) {
            System.out.println(buyingHistory);
        }
    }

    private void findBuyingHistoryById() {
        System.out.println("Input 'BuyingHistory_id': ");
        Integer buyingHistoryId = Integer.valueOf(input.nextLine());

        Optional<BuyingHistory> buyingHistory = buyingHistoryControler.findById(buyingHistoryId);
        System.out.println(buyingHistory.orElse(nullBuyingHistory));
    }

    //endregion
    // region Airport ---------------------------------------------------
    private void createAirport() {
        System.out.println("Input 'Airport_id': ");
        Integer airportId = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'Airport_name': ");
        String airportName = input.nextLine();
        
        System.out.println("Input 'Airport_country': ");
        String airportCountry = input.nextLine();
        
        System.out.println("Input 'Airport_city': ");
        String airportCity = input.nextLine();
        
        System.out.println("Input 'Airport_address': ");
        String airportAddress = input.nextLine();
        

        Airport airport = new Airport(airportId, airportName, airportCountry, airportCity, airportAddress);

        int count = airportControler.create(airport);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateAirport() {
    	System.out.println("Input 'Airport_id': ");
        Integer airportId = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'Airport_name': ");
        String airportName = input.nextLine();
        
        System.out.println("Input 'Airport_country': ");
        String airportCountry = input.nextLine();
        
        System.out.println("Input 'Airport_city': ");
        String airportCity = input.nextLine();
        
        System.out.println("Input 'Airport_address': ");
        String airportAddress = input.nextLine();
        

        Airport airport = new Airport(airportId, airportName, airportCountry, airportCity, airportAddress);

        int count = airportControler.update(airportId, airport);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromAirport() {
        System.out.println("Input 'Airport_id': ");
        Integer airportId = Integer.valueOf(input.nextLine());

        int count = airportControler.delete(airportId);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllAirports() {
        System.out.println("\nTable: Airport");
        List<Airport> airports = airportControler.findAll();
        for (Airport airport : airports) {
            System.out.println(airport);
        }
    }

    private void findAirportById() {
        System.out.println("Input 'Airport_id': ");
        Integer airportId = Integer.valueOf(input.nextLine());

        Optional<Airport> airport = airportControler.findById(airportId);
        System.out.println(airport.orElse(nullAirport));
    }


    //endregion
    // region UserProfile ---------------------------------------------------
    private void createUserProfile() {
        System.out.println("Input 'UserProfile_id': ");
        Integer userProfileId = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'UserProfile_name': ");
        String userProfileName = input.nextLine();
        
        System.out.println("Input 'UserProfile_surname': ");
        String userProfileSurname = input.nextLine();
        
        System.out.println("Input 'UserProfile_age': ");
        Integer userProfileAge = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'UserProfile_email': ");
        String userProfileEmail = input.nextLine();
        
        

        UserProfile userProfile = new UserProfile(userProfileId, userProfileName, userProfileSurname, userProfileAge, userProfileEmail);

        int count = userProfileControler.create(userProfile);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateUserProfile() {
    	System.out.println("Input 'UserProfile_id': ");
        Integer userProfileId = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'UserProfile_name': ");
        String userProfileName = input.nextLine();
        
        System.out.println("Input 'UserProfile_surname': ");
        String userProfileSurname = input.nextLine();
        
        System.out.println("Input 'UserProfile_age': ");
        Integer userProfileAge = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'UserProfile_email': ");
        String userProfileEmail = input.nextLine();
        
        

        UserProfile userProfile = new UserProfile(userProfileId, userProfileName, userProfileSurname, userProfileAge, userProfileEmail);

        int count = userProfileControler.update(userProfileId, userProfile);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromUserProfile() {
        System.out.println("Input 'userProfile_id': ");
        Integer userProfileId = Integer.valueOf(input.nextLine());

        int count = userProfileControler.delete(userProfileId);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllUserProfiles() {
        System.out.println("\nTable: UserProfile");
        List<UserProfile> userProfiles = userProfileControler.findAll();
        for (UserProfile userProfile : userProfiles) {
            System.out.println(userProfile);
        }
    }

    private void findUserProfileById() {
        System.out.println("Input 'UserProfile_id': ");
        Integer userProfileId = Integer.valueOf(input.nextLine());

        Optional<UserProfile> userProfile = userProfileControler.findById(userProfileId);
        System.out.println(userProfile.orElse(nullUserProfile));
    }

    //endregion
    // region FlightTicket ---------------------------------------------------
    private void createFlightTicket() {
    	System.out.println("Input flightTicket_id': ");
        Integer flightTicketId = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'flightTicket_type': ");
        String flightTicketType = input.nextLine();
        
        System.out.println("Input 'flightTicket_price': ");
        Double flightTicketPrice = Double.valueOf(input.nextLine());
        
        System.out.println("Input 'flightTicket_Avaiability': ");
        Integer flightTicketAvaiability = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'buyingHistory_Id': ");
        Integer buyingHistoryId = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'flightInfo_id ': ");
        Integer flightInfoId = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'connectedFlight_id': ");
        Integer connectedFlightId = Integer.valueOf(input.nextLine());

        FlightTicket flightTicket = new FlightTicket(flightTicketId, flightTicketType, flightTicketPrice, flightTicketAvaiability,buyingHistoryId, flightInfoId, connectedFlightId  );

        int count = flightTicketControler.create(flightTicket);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateFlightTicket() {
    	System.out.println("Input flightTicket_id': ");
        Integer flightTicketId = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'flightTicket_type': ");
        String flightTicketType = input.nextLine();
        
        System.out.println("Input 'flightTicket_price': ");
        Double flightTicketPrice = Double.valueOf(input.nextLine());
        
        System.out.println("Input 'flightTicket_Avaiability': ");
        Integer flightTicketAvaiability = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'buyingHistory_Id': ");
        Integer buyingHistoryId = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'flightInfo_id ': ");
        Integer flightInfoId = Integer.valueOf(input.nextLine());
        
        System.out.println("Input 'connectedFlight_id': ");
        Integer connectedFlightId = Integer.valueOf(input.nextLine());

        FlightTicket flightTicket = new FlightTicket(flightTicketId, flightTicketType, flightTicketPrice, flightTicketAvaiability,buyingHistoryId, flightInfoId, connectedFlightId  );

        int count = flightTicketControler.update(flightTicketId, flightTicket);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromFlightTicket() {
        System.out.println("Input 'FlightTicket_id': ");
        Integer flightTicketId = Integer.valueOf(input.nextLine());

        int count = flightTicketControler.delete(flightTicketId);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllFlightTickets() {
        System.out.println("\nTable: FlightTicket");
        List<FlightTicket> flightTickets = flightTicketControler.findAll();
        for (FlightTicket flightTicket : flightTickets) {
            System.out.println(flightTicket);
        }
    }

    private void findFlightTicketById() {
        System.out.println("Input 'FlightTicket_id': ");
        Integer flightTicketId = Integer.valueOf(input.nextLine());

        Optional<FlightTicket> flightTicket = flightTicketControler.findById(flightTicketId);
        System.out.println(flightTicket.orElse(nullFlightTicket));
    }

    //endregion
//endregion

    

    //-------------------------------------------------------------------------
    // region output
    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!keyMenu.equals("Q"));
    }
}

    //endregion



