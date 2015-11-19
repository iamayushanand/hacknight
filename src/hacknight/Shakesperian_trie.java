package hacknight.src.hacknight;

//import data_structures.Trie;



import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ayush on 17/11/2015.
 */

class Trie_node
{
    String value;
    ArrayList<Trie_node> children = new ArrayList<Trie_node>();
    boolean isLeaf;
    String[] Sentence;

    public Trie_node(String c){
        this.value=c;
    }

    public Trie_node(String c,String[] sentence){
        this.value=c;
        this.Sentence = sentence;
    }




}

class Actual_Trie
{
    public static Trie_node rootNode = new Trie_node(".");

    public static ArrayList<String> map(ArrayList<Trie_node> list){
        ArrayList<String> ret =  new ArrayList<String>();
        for(int i=0 ; i<list.size();i++){
            ret.add(list.get(i).value);
        }
        return ret;
    }

    public static void insert(String[] word){
        Trie_node curNode = rootNode;
        Trie_node n;
        for(int i=0;i<word.length;i++){
            if(!map(curNode.children).contains(word[i])){
                n=new Trie_node(word[i]);
                curNode.children.add(n);
                curNode = n;
            }else{
                curNode=curNode.children.get(map(curNode.children).indexOf(word[i]));
            }
        }

        curNode.isLeaf = true;
        curNode.Sentence = word;
    }

    public static boolean Search(String[] sentence){
        Trie_node curNode = rootNode;
        for(int i =0;i<sentence.length;i++){
            if(!(map(curNode.children).contains(sentence[i]))){
                return false;
            }else{
                curNode = curNode.children.get(map(curNode.children).indexOf(sentence[i]));
            }
        }

        if(curNode.isLeaf){return true;}
        //System.out.println(curNode.isLeaf);
        return false;
    }

    public static void printText(Trie_node n, boolean isThisLeaf){

        String printThis = "";
        if(isThisLeaf){
            if(n.isLeaf){
                System.out.println(Arrays.toString(n.Sentence));
            }
        }

        for(int i=0;i<n.children.size();i++){
            if(n.children.get(i)!=null ){

                if(n.children.get(i).isLeaf){
                    for(int j=0;j<n.children.get(i).Sentence.length;j++){
                        printThis=printThis+n.children.get(i).Sentence[j]+" ";
                    }
                    System.out.println(printThis);
                    printThis="";

                }
                printText(n.children.get(i),false);
            }

        }
    }

    public static void PrefixSuggestion(String[] word){
        Trie_node curNode = rootNode;
        for(int i =0;i<word.length;i++){
            for(int j=0;j<curNode.children.size();j++){
                if (curNode.children.get(j).value.equals(word[i])){
                    curNode = curNode.children.get(j);
                }


            }



        }
        if (curNode.value=="."){
            System.out.println("404 not found! error");
        }else{
        printText(curNode,true);
        }

    }

    public static void InsertSentence(String sentence){
        sentence = sentence.toLowerCase();
        insert(sentence.split(" "));
    }


    
}

public class Shakesperian_trie {
    public static void main(String[] args){
        String test = "From fairest creatures we desire increase,\n" +
                "That thereby beauty's rose might never die,\n" +
                "But as the riper should by time decease,\n" +
                "His tender heir might bear his memory:\n" +
                "But thou contracted to thine own bright eyes,\n" +
                "Feed'st thy light's flame with self-substantial fuel,\n" +
                "Making a famine where abundance lies,\n" +
                "Thy self thy foe, to thy sweet self too cruel:\n" +
                "Thou that art now the world's fresh ornament,\n" +
                "And only herald to the gaudy spring,\n" +
                "Within thine own bud buriest thy content,\n" +
                "And tender churl mak'st waste in niggarding:\n" +
                "Pity the world, or else this glutton be,\n" +
                "To eat the world's due, by the grave and thee.\n"+
                "When forty winters shall besiege thy brow,\n" +
                "And dig deep trenches in thy beauty's field,\n" +
                "Thy youth's proud livery so gazed on now,\n" +
                "Will be a tattered weed of small worth held:\n" +
                "Then being asked, where all thy beauty lies,\n" +
                "Where all the treasure of thy lusty days;\n" +
                "To say within thine own deep sunken eyes,\n" +
                "Were an all-eating shame, and thriftless praise.\n" +
                "How much more praise deserved thy beauty's use,\n" +
                "If thou couldst answer 'This fair child of mine\n" +
                "Shall sum my count, and make my old excuse'\n" +
                "Proving his beauty by succession thine.\n" +
                "This were to be new made when thou art old,\n" +
                "And see thy blood warm when thou feel'st it cold."+
                "Look in thy glass and tell the face thou viewest,\n" +
                "Now is the time that face should form another,\n" +
                "Whose fresh repair if now thou not renewest,\n" +
                "Thou dost beguile the world, unbless some mother.\n" +
                "For where is she so fair whose uneared womb\n" +
                "Disdains the tillage of thy husbandry?\n" +
                "Or who is he so fond will be the tomb,\n" +
                "Of his self-love to stop posterity?\n" +
                "Thou art thy mother's glass and she in thee\n" +
                "Calls back the lovely April of her prime,\n" +
                "So thou through windows of thine age shalt see,\n" +
                "Despite of wrinkles this thy golden time.\n" +
                "But if thou live remembered not to be,\n" +
                "Die single and thine image dies with thee."+
                "Unthrifty loveliness why dost thou spend,\n" +
                "Upon thy self thy beauty's legacy?\n" +
                "Nature's bequest gives nothing but doth lend,\n" +
                "And being frank she lends to those are free:\n" +
                "Then beauteous niggard why dost thou abuse,\n" +
                "The bounteous largess given thee to give?\n" +
                "Profitless usurer why dost thou use\n" +
                "So great a sum of sums yet canst not live?\n" +
                "For having traffic with thy self alone,\n" +
                "Thou of thy self thy sweet self dost deceive,\n" +
                "Then how when nature calls thee to be gone,\n" +
                "What acceptable audit canst thou leave?\n" +
                "Thy unused beauty must be tombed with thee,\n" +
                "Which used lives th' executor to be.\n"+
                "Those hours that with gentle work did frame\n" +
                "The lovely gaze where every eye doth dwell\n" +
                "Will play the tyrants to the very same,\n" +
                "And that unfair which fairly doth excel:\n" +
                "For never-resting time leads summer on\n" +
                "To hideous winter and confounds him there,\n" +
                "Sap checked with frost and lusty leaves quite gone,\n" +
                "Beauty o'er-snowed and bareness every where:\n" +
                "Then were not summer's distillation left\n" +
                "A liquid prisoner pent in walls of glass,\n" +
                "Beauty's effect with beauty were bereft,\n" +
                "Nor it nor no remembrance what it was.\n" +
                "But flowers distilled though they with winter meet,\n" +
                "Leese but their show, their substance still lives sweet.\n"+
                "Then let not winter's ragged hand deface,\n" +
                "In thee thy summer ere thou be distilled:\n" +
                "Make sweet some vial; treasure thou some place,\n" +
                "With beauty's treasure ere it be self-killed:\n" +
                "That use is not forbidden usury,\n" +
                "Which happies those that pay the willing loan;\n" +
                "That's for thy self to breed another thee,\n" +
                "Or ten times happier be it ten for one,\n" +
                "Ten times thy self were happier than thou art,\n" +
                "If ten of thine ten times refigured thee:\n" +
                "Then what could death do if thou shouldst depart,\n" +
                "Leaving thee living in posterity?\n" +
                "Be not self-willed for thou art much too fair,\n" +
                "To be death's conquest and make worms thine heir.\n"+
                "Lo in the orient when the gracious light\n" +
                "Lifts up his burning head, each under eye\n" +
                "Doth homage to his new-appearing sight,\n" +
                "Serving with looks his sacred majesty,\n" +
                "And having climbed the steep-up heavenly hill,\n" +
                "Resembling strong youth in his middle age,\n" +
                "Yet mortal looks adore his beauty still,\n" +
                "Attending on his golden pilgrimage:\n" +
                "But when from highmost pitch with weary car,\n" +
                "Like feeble age he reeleth from the day,\n" +
                "The eyes (fore duteous) now converted are\n" +
                "From his low tract and look another way:\n" +
                "So thou, thy self out-going in thy noon:\n" +
                "Unlooked on diest unless thou get a son.\n"+
                "Music to hear, why hear'st thou music sadly?\n" +
                "Sweets with sweets war not, joy delights in joy:\n" +
                "Why lov'st thou that which thou receiv'st not gladly,\n" +
                "Or else receiv'st with pleasure thine annoy?\n" +
                "If the true concord of well-tuned sounds,\n" +
                "By unions married do offend thine ear,\n" +
                "They do but sweetly chide thee, who confounds\n" +
                "In singleness the parts that thou shouldst bear:\n" +
                "Mark how one string sweet husband to another,\n" +
                "Strikes each in each by mutual ordering;\n" +
                "Resembling sire, and child, and happy mother,\n" +
                "Who all in one, one pleasing note do sing:\n" +
                "Whose speechless song being many, seeming one,\n" +
                "Sings this to thee, 'Thou single wilt prove none'.\n"+
                "For shame deny that thou bear'st love to any\n" +
                "Who for thy self art so unprovident.\n" +
                "Grant if thou wilt, thou art beloved of many,\n" +
                "But that thou none lov'st is most evident:\n" +
                "For thou art so possessed with murd'rous hate,\n" +
                "That 'gainst thy self thou stick'st not to conspire,\n" +
                "Seeking that beauteous roof to ruinate\n" +
                "Which to repair should be thy chief desire:\n" +
                "O change thy thought, that I may change my mind,\n" +
                "Shall hate be fairer lodged than gentle love?\n" +
                "Be as thy presence is gracious and kind,\n" +
                "Or to thy self at least kind-hearted prove,\n" +
                "Make thee another self for love of me,\n" +
                "That beauty still may live in thine or thee.\n";


        test=test.toLowerCase();
        test.trim();
        String[] testThis = test.split("\n");
        for(int i =0 ;i<testThis.length;i++){
            for(int j =0;j<testThis[i].length();j++){

                testThis[i].replaceAll("[^A-Za-z0-9 ]","");


            }
        }

        for(int i =0 ;i<testThis.length;i++){
            Actual_Trie.InsertSentence(testThis[i]);
        }


        Scanner in = new Scanner(System.in);

        while(true){
            //Actual_Trie.printText(Actual_Trie.rootNode.children.get(0),true);
            System.out.println("Please enter the word you want to search");
            java.util.Date date= new java.util.Date();

            Actual_Trie.PrefixSuggestion(in.nextLine().split(" "));
            java.util.Date date2= new java.util.Date();
            long milliseconds = date2.getTime()-date.getTime();
            System.out.println("Time taken to give the result:"+milliseconds+" ms");
        }
    }
}
