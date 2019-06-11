package com.pict.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pict.dao.EvenementDao;
import com.pict.dao.LieuDao;
import com.pict.dao.PersonneDao;
import com.pict.entity.Evenement;
import com.pict.entity.Lieu;
import com.pict.entity.Personne;


@Controller
public class MyController {
	@Autowired
	PersonneDao pDao;
	
	@Autowired
	LieuDao lieudao;
	
	@Autowired
	EvenementDao evenementdao;
	
	
	// Affichage de la page index
	@RequestMapping("/")
	public String crtlAccueil(Map<String, Object> model, HttpSession session, HttpServletRequest request) throws Exception {					
		List<Personne> liste=pDao.getAllPersonne();
		model.put("listePersonne", liste);
		
		return "index";
	}
	
	@RequestMapping(value = "/AutocompleteNom")
	@ResponseBody
	public List<String> ctrlAutocompleteNom(@RequestParam(value="term",required=false,defaultValue="") String term) {
		List<String> suggestion=new ArrayList<String>();
		List<Personne> liste=pDao.Autocomplete(term);
		
		for(Personne p:liste) {
			suggestion.add(p.toString());
		}
		
		return suggestion;
	}
	
	@RequestMapping(value = "/AutocompleteLieu")
	@ResponseBody
	public List<String> ctrlAutocompleteLieu(@RequestParam(value="term",required=false,defaultValue="") String term) {
		List<String> suggestion=new ArrayList<String>();
		List<Lieu> liste=lieudao.Autocomplete(term);
		
		for(Lieu l:liste) {
			suggestion.add(l.toString());
		}
		
		return suggestion;
	}
	

	@RequestMapping(value = "/AutocompleteEvenement")
	@ResponseBody
	public List<String> ctrlAutocompleteEvenement(@RequestParam(value="term",required=false,defaultValue="") String term) {
		List<String> suggestion=new ArrayList<String>();
		List<Evenement> liste=evenementdao.Autocomplete(term);
		
		for(Evenement l:liste) {
			suggestion.add(l.toString());
		}
		
		return suggestion;
	}
	
	@RequestMapping("/test")
	public String crtlTest(Model model, HttpSession session, HttpServletRequest request) throws Exception {
	

		
		return "test";
	}
}