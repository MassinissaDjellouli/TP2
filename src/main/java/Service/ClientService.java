package Service;

import Database.BiblioDAO;
import Models.Dette;
import Models.Documents.Documents;
import Models.Documents.Livre;
import Models.Documents.Media;
import Models.Emprunt;
import Models.Enums.Genres;
import Models.Enums.MediaType;
import Models.Users.Client;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClientService {
    private BiblioDAO DB;

    public ClientService(BiblioDAO DBClient) {
        this.DB = DBClient;
    }
    public void saveNewClient(String name,String adress, String phone){
        Dette dette = new Dette();
        Client toSave = Client.builder()
                        .clientName(name)
                        .clientPhone(phone)
                        .clientAdress(adress)
                        .build();
        dette.setClient(toSave);
        toSave.setDette(dette);
        DB.save(toSave);
    }
    public void addDetteToClient(int id, float montant){

        try {
            Client client = DB.findClientById(id);
            Dette oldDette = client.getDette();
            Dette dette = Dette.builder()
                    .montant(montant)
                    .dateDebut(LocalDateTime.now())
                    .id(oldDette.getId())
                    .build();
            client.setDette(dette);
            dette.setClient(client);
            DB.merge(dette);
            DB.merge(client);
        }catch (IllegalArgumentException e){
            DB.handleException("Une erreur est survenue avec la base de donnée");
        }
    }
    public Client getClientById(int id){
        return DB.findClientByIdWEmprunts(id);
    }
    public List<Emprunt> getClientEmprunts(int clientId){
        Client client = getClientById(clientId);
        return client.getEmprunts();
    }
    public Set<Client> getAllClients(){
        return DB.findAllClient();
    }
    public Set<Client> getAllClientsWEmprunt(){
        return DB.findAllClientWEmprunts();
    }
    public void saveNewLivre(String titre, String auteur,
                             String editeur, int anneDePublication,
                             int nbExemplaire, int nbPages, Genres genre){
        Livre toSave = Livre.builder()
                .titre(titre)
                .auteur(auteur)
                .editeur(editeur)
                .anneeDePublication(anneDePublication)
                .nbExemplaires(nbExemplaire)
                .nbPages(nbPages)
                .tempsEmprunt(3)
                .genre(genre)
                .build();
        if (checkIfLivrePresent(toSave)){
            addExemplaire(toSave);
        }else {
            DB.save(toSave);
        }
    }

    private void addExemplaire(Documents document) {
        document.setNbExemplaires(document.getNbExemplaires() + 1);
        DB.merge(document);
    }

    private boolean checkIfLivrePresent(Livre toCheck){
        Set<Livre> livres = DB.findAllLivre();
        for (Livre livre : livres){
            if(livre.equals(toCheck)){
                return true;
            }
        }
        return false;
    }
    public void saveNewMedia(String titre, String auteur,
                             String editeur, int anneDePublication,
                             int nbExemplaire, String duree, MediaType type){
        Media toSave = Media.builder()
                .titre(titre)
                .auteur(auteur)
                .editeur(editeur)
                .anneeDePublication(anneDePublication)
                .nbExemplaires(nbExemplaire)
                .duree(duree)
                .type(type)
                .tempsEmprunt(Documents.setMediaTempsEmprunts(type))
                .build();
        DB.save(toSave);
    }
    public Set<Livre> rechercheLivreTitre(String titre){
        Set<Livre> livres = DB.findAllLivre();
        Set<Livre> toReturn = new HashSet<>();
        for (Livre livre : livres){
            if (livre.getTitre().contains(titre)){
                toReturn.add(livre);
            }
        }
        return toReturn;
    }
    public Set<Livre> rechercheLivreAuteur(String auteur){
        Set<Livre> livres = DB.findAllLivre();
        Set<Livre> toReturn = new HashSet<>();
        for (Livre livre : livres){
            if (livre.getAuteur().equals(auteur)){
                toReturn.add(livre);
            }
        }
        return toReturn;
    }
    public Set<Livre> rechercheLivreAnne(int annee){
        Set<Livre> livres = DB.findAllLivre();
        Set<Livre> toReturn = new HashSet<>();
        for (Livre livre : livres){
            if (livre.getAnneeDePublication() == annee){
                toReturn.add(livre);
            }
        }
        return toReturn;
    }
    public Set<Livre> rechercheLivreGenre(Genres genre){
        Set<Livre> livres = DB.findAllLivre();
        Set<Livre> toReturn = new HashSet<>();
        for (Livre livre : livres){
            if (livre.getGenre() == (genre)){
                toReturn.add(livre);
            }
        }
        return toReturn;
    }
    public Set<Media> rechercheMediaTitre(String titre){
        Set<Media> medias = DB.findAllMedia();
        Set<Media> toReturn = new HashSet<>();
        for (Media media : medias){
            if (media.getTitre().contains(titre)){
                toReturn.add(media);
            }
        }
        return toReturn;
    }
    public Set<Media> rechercheMediaAuteur(String auteur){
        Set<Media> medias = DB.findAllMedia();
        Set<Media> toReturn = new HashSet<>();
        for (Media media : medias){
            if (media.getAuteur().equals(auteur)){
                toReturn.add(media);
            }
        }
        return toReturn;
    }
    public Set<Media> rechercheMediaAnne(int annee){
        Set<Media> medias = DB.findAllMedia();
        Set<Media> toReturn = new HashSet<>();
        for (Media media : medias){
            if (media.getAnneeDePublication() == annee ){
                toReturn.add(media);
            }
        }
        return toReturn;
    }
    public Set<Media> rechercheMediaType(MediaType type){
        Set<Media> medias = DB.findAllMedia();
        Set<Media> toReturn = new HashSet<>();
        for (Media media : medias){
            if (media.getType() == type){
                toReturn.add(media);
            }
        }
        return toReturn;
    }
}
