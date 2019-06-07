package com.pict.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class phototController {

	/* _____ BLOC MÉTHODES --> _____*/
	
	
	// Affichage de la page index
	@RequestMapping("/")
	public String accueil(Model model, HttpSession session, HttpServletRequest request) throws Exception {
	
		return "index";
	}
}