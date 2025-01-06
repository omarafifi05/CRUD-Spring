    package com.bmt.webapp.Controller;

    import java.util.Optional;
    import com.bmt.webapp.model.ClientDto;
    import com.bmt.webapp.model.Clients;
    import com.bmt.webapp.repositories.ClientRepository;
    import jakarta.validation.Valid;
    import org.hibernate.query.SortDirection;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.data.domain.Sort;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.validation.BindingResult;
    import org.springframework.validation.BindingResultUtils;
    import org.springframework.validation.FieldError;
    import org.springframework.web.bind.annotation.*;
    import org.yaml.snakeyaml.events.Event;

    import java.util.Date;

    @Controller
    @RequestMapping("/clients")
    public class ClientsController {
        @Autowired
        private ClientRepository CP;
        @GetMapping({"","/"})
        public String GetClients(Model model){
            var clients = CP.findAll(Sort.by(Sort.Direction.DESC, "id"));
            model.addAttribute("clients",clients);
             return "clients/index";
        }

        @GetMapping("create")
        public String crateClients(Model model){
            ClientDto ClientDto = new ClientDto();
            model.addAttribute("clientDto", ClientDto);
            return "clients/create";
        }
        @PostMapping("/create")
        public String createClient(
                @Valid @ModelAttribute ClientDto clientDto,
                BindingResult result
        ) {
            if (CP.findByEmail(clientDto.getEmail()) != null) {
                result.addError(
                        new FieldError("clientDto", "email", clientDto.getEmail(), false, null, null, "Email Already Exists")
                );
            }

            if (result.hasErrors()) {
                return "clients/create";
            }

            Clients clients = new Clients();
            clients.setFirstName(clientDto.getFirstName());
            clients.setLastName(clientDto.getLastName());
            clients.setEmail(clientDto.getEmail());
            clients.setAddress(clientDto.getAddress());
            clients.setPhone(clientDto.getPhone());
            clients.setStatus(clientDto.getStatus());
            clients.setCreatedAt(new Date());
            CP.save(clients);
            return "redirect:/clients";
        }
        @GetMapping("/edit")
        public String editClient(
               Model model ,
               @RequestParam int id)
            {

                Clients client = CP.findById(id).orElse(null);

                if (client == null) {
            return "redirect:/clients";
            }

            ClientDto clientDto = new ClientDto();
            clientDto.setFirstName(client.getFirstName());
            clientDto.setLastName(client.getLastName());
            clientDto.setEmail(client.getEmail());
            clientDto.setAddress(client.getAddress());
            clientDto.setPhone(client.getPhone());
            clientDto.setStatus(client.getStatus());

            model.addAttribute("client",client);
            model.addAttribute("clientDto",clientDto);
            return "clients/edit";
        }

        @PostMapping("/edit")
        public String editClient(
                Model model,
                @RequestParam int id,
                @Valid @ModelAttribute("clientDto") ClientDto clientDto,
                BindingResult result
        ) {
            Clients client = CP.findById(id).orElse(null);
            if (client == null) {
                return "redirect:/clients";
            }

            if (result.hasErrors()) {
                model.addAttribute("client", client);
                return "clients/edit";
            }

            client.setFirstName(clientDto.getFirstName());
            client.setLastName(clientDto.getLastName());
            client.setEmail(clientDto.getEmail());
            client.setPhone(clientDto.getPhone());
            client.setAddress(clientDto.getAddress());
            client.setStatus(clientDto.getStatus());

            CP.save(client);
            return "redirect:/clients";
        }


        @GetMapping("/delete")
        public String deleteClient(@RequestParam int id){

            Clients client = CP.findById(id).orElse(null);
            if (client != null){
                CP.delete(client);

            }
            return "redirect:/clients";
        }
    }
