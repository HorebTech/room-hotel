package com.room.hotel.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.room.hotel.dto.ChangePasswordRequest;
import com.room.hotel.exception.ResourceNotFoundException;
import com.room.hotel.model.Utilisateur;
import com.room.hotel.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UtilisateurService {

    private final PasswordEncoder passwordEncoder;
    private final UtilisateurRepository utilisateurRepository;

    public Utilisateur registerUser(Utilisateur utilisateur) {
        if (utilisateurRepository.findByEmail(utilisateur.getEmail()).isPresent()) {
            throw new IllegalStateException("Email déjà utilisé!");
        }
        if (utilisateurRepository.findFirstByOrderByCreatedDate() == null) {
            utilisateur.setRole(Utilisateur.Role.MANAGER);
        } else {
            utilisateur.setRole(Utilisateur.Role.AGENT);
        }
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur getUserByEmail(String email) {
        return utilisateurRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé!"));
    }

    public void changePassword(String email, ChangePasswordRequest request) {
        Utilisateur utilisateur = getUserByEmail(email);
        if (!passwordEncoder.matches(request.getCurrentPassword(), utilisateur.getPassword())) {
            throw new BadCredentialsException("Le mot de passe actuel est erroné!");
        }

        utilisateur.setPassword(passwordEncoder.encode(request.getNewPassword()));
        utilisateurRepository.save(utilisateur);
    }

}
