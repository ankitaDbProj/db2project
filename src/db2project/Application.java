package db2project;

import entities.*;
import services.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class Application {

    public static void main(String[] args) throws SQLException {
        // EntryPoint of the app
        // Start UI here...


        // DB-MANAGEMENT TESTS
        // ==== PARTY =====
        PartyService ps = new PartyService();
        Party party = new Party("pirates", "arrr", "cute image");
        //ps.create(party);
        //Party res = ps.getById(1);
        //ArrayList<Party> res = ps.getAll();
        //ps.delete(3);

        // ==== ELECTION =====
        ElectionService es = new ElectionService();
        Election election = new Election(new Date(2019, 10, 23), "president election", new Date(2019, 10, 30));
        //es.create(election);
        //Election res = es.getById(1);
        //ArrayList<Election> res = es.getAll();
        //es.delete(2);

        // ==== USER =====
        UserService us = new UserService();
        User user = new User("Bob", 1, "bob@lol.com", 1);
        //us.create(user);
        //User res = us.getById(4);
        //ArrayList<User> res = us.getAll();
        //us.delete(5);

        // ==== CANDIDATE =====
        CandidateService cs = new CandidateService();
        Candidate candidate = new Candidate("Paul", 31, "smily", 1, 1);
        //cs.create(candidate);
        //Candidate res = cs.getById(3);
        //ArrayList<Candidate> res = cs.getAll();
        //cs.delete(4);

        // ==== VOTTE =====
        VoteService vs = new VoteService();
        Vote vote = new Vote(new Date(2019, 10, 23), 3,4);
        //vs.create(vote);
        //Vote res = vs.getById(1);
        //ArrayList<Vote> res = vs.getAll();
        //vs.delete(2);

        int i = 0;
    }
}
