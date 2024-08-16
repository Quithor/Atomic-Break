package top.yanquithor.chemistry.base;

import top.yanquithor.chemistry.exception.ChemistryException;

public class Particle {
    
    private final int proton;                   // 质子
    private int valency;                        // 当化合价为负时当前对象为阴离子
    private int[] valenceElectron;
    
    private static final String[] NAMES = {
    "H",                                                                               "He",
    "Li","Be",                                                "B", "C", "N", "O", "F", "Ne",
    "Na","Mg",                                                "Al","Si","P", "S", "Cl","Ar",
    "K","Ca","Sc","Ti","V","Cr","Mn","Fe","Co","Ni","Cu","Zi","Ga","Ge","As","Se","Br","Kr",
    "Rb","Sr","Y","Zr","Nb","Mo","Tc","Ru","Rh","Pd","Ag","Cd","In","Sn","Sb","Te","I","Xe",
    "Cs","Ba",
            "La","Ce","Pr","Nd","Pm","Sm","Eu","Gd","La","Dy","Ho","Er","Tm","Yb","Lu",
                  "Hf","Ta","W","Re","Os","Ir","Pt","Au","Hg","Tl","Pb","Bi","Po","At","Rn",
    "Fr","Ra",
            "Ac","Th","Pa","U", "Np","Pu","Am","Cm","Bk","Cf","Es","Fm","Md","No","Lr",
                 "Rf","Db","Sg","Bh","Hs","Mt","Ds","Rg","Cn","Unt","Fl","Uup","Lv","Uns","Uuo"
    };
    private static final int[][] VALENCE_ELECTRONS={
    {11,0,0,0},                                                                                                                                                                                            {12, 0,0,0},
    {21,0,0,0},{22,0,0,0},                                                                                                                     {22,21,0,0},{22,22,0,0},{22,23,0,0},{22,24,0,0},{22,25,0,0},{22,26,0,0},
    {31,0,0,0},{32,0,0,0},                                                                                                                     {32,31,0,0},{32,32,0,0},{32,33,0,0},{32,34,0,0},{32,35,0,0},{32,36,0,0},
    {41,0,0,0},{42,0,0,0},{42,0,301,0},{42,0,302,0},{42,0,303,0},{41,0,305,0},{42,0,305,0},{42,0,306,0},{42,0,307,0},{42,0,308,0},{41,0,310,0},{42,0,310,0},{42,41,0,0},{42,42,0,0},{42,43,0,0},{42,44,0,0},{42,45,0,0},{42,46,0,0},
    {51,0,0,0},{52,0,0,0},{52,0,401,0},{52,0,402,0},{52,0,403,0},{51,0,405,0},{52,0,405,0},{52,0,406,0},{52,0,407,0},{52,0,408,0},{51,0,410,0},{52,0,410,0},{52,51,0,0},{52,52,0,0},{52,53,0,0},{52,54,0,0},{52,55,0,0},{52,56,0,0},
    {61,0,0,0},{62,0,0,0},{62,0,501,0},
            {62,0,501,0},{62,0,501,401},{62,0,0,403},{62,0,0,404},{62,0,0,405},{62,0,0,406},{62,0,0,407},{62,0,501,407},{62,0,0,409},{62,0,0,410},{62,0,0,411},{62,0,0,412},{62,0,0,413},{62,0,0,414},{62,0,501,414},
                                       {62,0,502,0},{62,0,503,0},{62,0,504,0},{62,0,505,0},{62,0,506,0},{62,0,507,0},{61,0,509,0},{61,0,510,0},{62,0,510,0},{62,61,0,0},{62,62,0,0},{62,63,0,0},{62,64,0,0},{62,65,0,0},{62,66,0,0},
    {71,0,0,0},{72,0,0,0},{72,0,601,0},
            {72,0,501,0},{72,0,0,502},{72,0,0,503},{72,0,601,503},{72,0,601,504},{72,0,0,506},{72,0,0,507},{72,0,601,507},{72,0,0,509},{72,0,0,510},{72,0,0,511},{72,0,0,512},{72,0,0,513},{72,0,0,514},{72,0,601,514},
                                       {72,0,602,0},{72,0,603,0},{72,0,604,0},{72,0,605,0},{72,0,606,0},{72,0,607,0},{72,0,608,0},{71,0,610,0},{72,0,610,0},{72,71,0,0},{72,72,0,0},{72,73,0,0},{72,74,0,0},{72,75,0,0},{72,76,0,0},
    };
    
    public Particle(int proton) {
        if (proton < 0) throw new ChemistryException("Hava not Proton Exception.");
        else if (proton > 118) throw new ChemistryException("No chemical elements have been discovered/synthesized.");
        this.proton = proton;
        this.valenceElectron = new int[4];
        for (int i = 0; i < valenceElectron.length; i++)
            valenceElectron[i] = VALENCE_ELECTRONS[proton - 1][i];
    }
    
    public Particle addElectron(int electron) {
        
        return this;
    }
    
    public Particle setValency(int valency) {
        this.valency = valency;
        return this;
    }
    public Particle setValenceElectron(int[] valenceElectron) {
        this.valenceElectron = valenceElectron;
        return this;
    }
    
    public int[] getValenceElectron() {
        return valenceElectron;
    }
    public int getValency() {
        return valency;
    }
    public int getProton() {
        return proton;
    }
    public int getPeriod() {
        // 获取元素所处的元素周期
        if (proton == 1) return 1;
        else if (proton < 1) throw new ChemistryException("Hava not Proton Exception.");
        else if (proton > 118) throw new ChemistryException("No chemical elements have been discovered/synthesized.");
        else {
            int sum = 0;
            for (int i = 0; i < proton; i++) {
                sum += (i * i * 2);
                if (proton < sum) return i + 1;
            }
        }
        return 0;
    }
    public int getGroup() {
        return switch (proton) {
            case 1,3,11,19,37,55,87 -> 1;
            case 4,12,20,38,56,88 -> 2;
            case 21,39,
                 57,58,59,60,61,62,63,64,65,66,67, 68, 69, 70, 71,
                 89,90,91,92,93,94,95,96,97,98,99,100,101,102,103
                    -> -3;
            case 22,40,72,104 -> -4;
            case 23,41,73,105 -> -5;
            case 24,42,74,106 -> -6;
            case 25,43,75,107 -> -7;
            case 29,47,79,111 -> -1;
            case 30,48,80,112 -> -2;
            case 5,13,31,49,81,113 -> 3;
            case 6,14,32,50,82,114 -> 4;
            case 7,15,33,51,83,115 -> 5;
            case 8,16,34,52,84,116 -> 6;
            case 9,17,35,53,85,117 -> 7;
            case 2,10,18,36,54,86,118 -> 0;
            default -> 8;
        };
    }
    
    public String display(){
        StringBuilder sb = new StringBuilder();
        sb.append("name: ");
        if (proton > 118) sb.append("");
        else sb.append(NAMES[proton -1]);
        sb.append(",\ngroup: ");
        switch (getGroup()) {
            case 0 : sb.append("第0族");break;
            case 1 : sb.append("第I主族");break;
            case 2 : sb.append("第II主族");break;
            case 3 : sb.append("第III主族");break;
            case 4 : sb.append("第IV主族");break;
            case 5 : sb.append("第V主族");break;
            case 6 : sb.append("第VI主族");break;
            case 7 : sb.append("第VII主族");break;
            case -1 : sb.append("第I副族");break;
            case -2 : sb.append("第II副族");break;
            case -3 : sb.append("第III副族");break;
            case -4 : sb.append("第IV副族");break;
            case -5 : sb.append("第V副族");break;
            case -6 : sb.append("第VI副族");break;
            case -7 : sb.append("第VII副族");break;
            case 8 : sb.append("第VIII族");break;
        }
        sb.append("\nperiod: 第");
        sb.append(getPeriod());
        sb.append("周期");
        return sb.toString();
    }
}
