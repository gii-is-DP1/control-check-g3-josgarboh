package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {
	
	@Autowired
	private RecoveryRoomService recoveryRoomService;
	
	private static final String VIEWS_RECOVERYROOM_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
	
	@GetMapping(path = "/create")
	public String initCreationForm(ModelMap modelMap) {
		String view = VIEWS_RECOVERYROOM_CREATE_OR_UPDATE_FORM;
		
		modelMap.addAttribute("recoveryRoom", new RecoveryRoom());
		modelMap.addAttribute("types", recoveryRoomService.getAllRecoveryRoomTypes());
		
		return view;
		
	}
	
	@PostMapping(path = "/create")
	public String processCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result, ModelMap modelMap) {
		String view = "welcome";
		if(result.hasErrors()) {
			modelMap.addAttribute("recoveryRoom", recoveryRoom);
			modelMap.addAttribute("types", recoveryRoomService.getAllRecoveryRoomTypes());
			return VIEWS_RECOVERYROOM_CREATE_OR_UPDATE_FORM;
		} else {
			
			recoveryRoomService.save(recoveryRoom);
			modelMap.addAttribute("message", "Recovery Room succesfully saved!");
		}
		return view;
	}
    
}
