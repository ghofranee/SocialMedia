package models;
import database.Connexion;
import javax.persistence.*;

@Entity
public class MemberShip {
    @EmbeddedId
    private MemberShipID membershipId;

    @ManyToOne
   private  Membre sourceMembre;
    @ManyToOne
   private Membre targetMembre;


    @Override
    public String toString() {
        return "MemberShip{" +
                "membershipId=" + membershipId +
                '}';
    }

    public MemberShipID getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(MemberShipID membershipId) {
        this.membershipId = membershipId;
    }

    public MemberShip(Long sourceMembre, Long targetMembre) {
        this.membershipId = new MemberShipID(sourceMembre,targetMembre);

        try{
               this.sourceMembre= (Membre)Connexion.find(Membre.class ,sourceMembre);
               this.targetMembre= (Membre)Connexion.find(Membre.class, targetMembre);
            }  catch (NoResultException e)
            {
                System.out.println("error");
            }
    }

    public MemberShip() {
    }

    public Membre getSourceMembre() {
        return sourceMembre;
    }

    public void setSourceMembre(Membre sourceMembre) {
        this.sourceMembre = sourceMembre;
    }

    public Membre getTargetMembre() {
        return targetMembre;
    }

    public void setTargetMembre(Membre targetMembre) {
        this.targetMembre = targetMembre;
    }
}
