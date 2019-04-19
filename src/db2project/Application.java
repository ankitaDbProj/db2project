package db2project;

import entities.*;
import services.*;

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
        //Party res = ps.getById(3);
        //ArrayList<Party> res = ps.getAll();
        //ps.delete(3);

        // ==== ELECTION =====
        ElectionService es = new ElectionService();
        Election election = new Election(new Date(2019, 10, 23), "president election", new Date(2019, 10, 30));
        //es.create(election);
        //Election res = es.getById(2);
        //ArrayList<Election> res = es.getAll();
        //es.delete(3);

        // ==== USER =====
        UserService us = new UserService();
        User user = new User("Bob", 1, "bob@lol.com", 1);
        //us.create(user);
        //User res = us.getById(1);
        //ArrayList<User> res = us.getAll();
        //us.delete(2);

        // ==== CANDIDATE =====
        CandidateService cs = new CandidateService();
        Candidate candidate = new Candidate("Paul", 31, "smily", 2, 1);
        //cs.create(candidate);
        //Candidate res = cs.getById(3);
        //ArrayList<Candidate> res = cs.getAll();
        //cs.delete(3);
        //ArrayList<Candidate> res = cs.getAllByParty(1);
        //ArrayList<Candidate> res = cs.getAllByElection(2);

        // ==== VOTTE =====
        VoteService vs = new VoteService();
        Vote vote = new Vote(new Date(2019, 10, 23), 2,1, 2);
        //vs.create(vote);
        //Vote res = vs.getById(4);
        //ArrayList<Vote> res = vs.getAll();
        //vs.delete(4);
        //ArrayList<Vote> res = vs.getAllByCandidate(2);
        //ArrayList<Vote> res = vs.getAllByUser(1);
        ArrayList<Vote> res = vs.getAllByElection(2);

        int i = 0;
    }
}
