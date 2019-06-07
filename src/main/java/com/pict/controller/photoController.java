package com.pict.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pict.dao.PersonneDao;
import com.pict.entity.Personne;


@Controller
public class photoController {
	
	@Autowired
	PersonneDao pDao;
	
	
	// Affichage de la page index
	@RequestMapping("/")
	public String crtlAccueil(Model model, HttpSession session, HttpServletRequest request) throws Exception {
	
		System.out.println("Accueil");
		
		return "index";
	}
	
	@RequestMapping(value = "/AutocompleteNom")
	@ResponseBody
	public List<String> ctrlGetNom(@RequestParam(value="term",required=false,defaultValue="") String term) {
		List<String> suggestion=new ArrayList<String>();
		List<Personne> liste=pDao.getPersonneByNom(term);
		
		for(Personne p:liste) {
			suggestion.add(p.toString());
		}
		
		return suggestion;
	}
}