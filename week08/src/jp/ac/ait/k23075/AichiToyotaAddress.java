package jp.ac.ait.k23075;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AichiToyotaAddress {
    /**
     * 愛知県豊田市の郵便番号と地名のMap
     * 
     * Collections.unmodifiableMap()を使用することで変更不可のMapを生成できます。
     */
    public static final Map<String, String> POSTALCODE_MAP = Collections.unmodifiableMap(new HashMap<String, String>() {
        {
            put("4710052", "愛知県豊田市逢妻町");
            put("4700335", "愛知県豊田市青木町");
            put("4710873", "愛知県豊田市秋葉町");
            put("4710835", "愛知県豊田市曙町");
            put("4442832", "愛知県豊田市浅谷町");
            put("4710858", "愛知県豊田市朝日ケ丘");
            put("4710031", "愛知県豊田市朝日町");
            put("4442843", "愛知県豊田市旭八幡町");
            put("4442423", "愛知県豊田市安実京町");
            put("4442817", "愛知県豊田市明賀町");
            put("4442601", "愛知県豊田市明川町");
            put("4442513", "愛知県豊田市足助白山町");
            put("4442424", "愛知県豊田市足助町");
            put("4443202", "愛知県豊田市阿蔵町");
            put("4442418", "愛知県豊田市綾渡町");
            put("4700333", "愛知県豊田市荒井町");
            put("4443216", "愛知県豊田市蘭町");
            put("4442827", "愛知県豊田市有間町");
            put("4442807", "愛知県豊田市伊熊町");
            put("4442824", "愛知県豊田市池島町");
            put("4710001", "愛知県豊田市池田町");
            put("4730928", "愛知県豊田市生駒町");
            put("4442837", "愛知県豊田市一色町");
            put("4700471", "愛知県豊田市石畳町");
            put("4700463", "愛知県豊田市石飛町");
            put("4700329", "愛知県豊田市石野町");
            put("4710803", "愛知県豊田市泉町");
            put("4710006", "愛知県豊田市市木町");
            put("4442825", "愛知県豊田市市平町");
            put("4700574", "愛知県豊田市市場町");
            put("4710814", "愛知県豊田市五ケ丘");
            put("4412513", "愛知県豊田市稲武町");
            put("4700372", "愛知県豊田市井上町");
            put("4442354", "愛知県豊田市井ノ口町");
            put("4700374", "愛知県豊田市伊保町");
            put("4710823", "愛知県豊田市今町");
            put("4442225", "愛知県豊田市岩倉町");
            put("4700515", "愛知県豊田市岩下町");
            put("4710003", "愛知県豊田市岩滝町");
            put("4442331", "愛知県豊田市岩谷町");
            put("4710015", "愛知県豊田市上野町");
            put("4442204", "愛知県豊田市鵜ケ瀬町");
            put("4442801", "愛知県豊田市牛地町");
            put("4442416", "愛知県豊田市有洞町");
            put("4701211", "愛知県豊田市畝部東町");
            put("4701219", "愛知県豊田市畝部西町");
            put("4442604", "愛知県豊田市上八木町");
            put("4710064", "愛知県豊田市梅坪町");
            put("4442406", "愛知県豊田市漆畑町");
            put("4443203", "愛知県豊田市宇連野町");
            put("4710866", "愛知県豊田市上挙母");
            put("4700341", "愛知県豊田市上原町");
            put("4710067", "愛知県豊田市栄生町");
            put("4700562", "愛知県豊田市永太郎町");
            put("4701206", "愛知県豊田市永覚新町");
            put("4701205", "愛知県豊田市永覚町");
            put("4442206", "愛知県豊田市王滝町");
            put("4710058", "愛知県豊田市大池町");
            put("4442501", "愛知県豊田市大井町");
            put("4700401", "愛知県豊田市大岩町");
            put("4442217", "愛知県豊田市大内町");
            put("4700511", "愛知県豊田市大ケ蔵連町");
            put("4442525", "愛知県豊田市大河原町");
            put("4442511", "愛知県豊田市大蔵町");
            put("4443207", "愛知県豊田市大桑町");
            put("4700532", "愛知県豊田市大坂町");
            put("4730935", "愛知県豊田市大島町");
            put("4700342", "愛知県豊田市大清水町");
            put("4442405", "愛知県豊田市大蔵連町");
            put("4700555", "愛知県豊田市大平町");
            put("4442603", "愛知県豊田市大多賀町");
            put("4442811", "愛知県豊田市太田町");
            put("4442515", "愛知県豊田市大塚町");
            put("4442822", "愛知県豊田市大坪町");
            put("4443242", "愛知県豊田市大沼町");
            put("4412511", "愛知県豊田市大野瀬町");
            put("4700355", "愛知県豊田市大畑町");
            put("4730902", "愛知県豊田市大林町");
            put("4700553", "愛知県豊田市大洞町");
            put("4710815", "愛知県豊田市大見町");
            put("4700552", "愛知県豊田市乙ケ林町");
            put("4710857", "愛知県豊田市小川町");
            put("4442812", "愛知県豊田市押井町");
            put("4701207", "愛知県豊田市鴛鴨町");
            put("4700303", "愛知県豊田市押沢町");
            put("4412516", "愛知県豊田市押山町");
            put("4412525", "愛知県豊田市小田木町");
            put("4442809", "愛知県豊田市小滝野町");
            put("4710072", "愛知県豊田市落合町");
            put("4442846", "愛知県豊田市小渡町");
            put("4700346", "愛知県豊田市乙部ケ丘");
            put("4700347", "愛知県豊田市乙部町");
            put("4442844", "愛知県豊田市伯母沢町");
            put("4700572", "愛知県豊田市小原大倉町");
            put("4700502", "愛知県豊田市小原北町");
            put("4700501", "愛知県豊田市小原田代町");
            put("4700531", "愛知県豊田市小原町");
            put("4700464", "愛知県豊田市折平町");
            put("4700323", "愛知県豊田市小呂町");
            put("4442334", "愛知県豊田市国閑町");
            put("4700348", "愛知県豊田市貝津町");
            put("4710855", "愛知県豊田市柿本町");
            put("4442352", "愛知県豊田市篭林町");
            put("4442813", "愛知県豊田市加塩町");
            put("4700505", "愛知県豊田市柏ケ洞町");
            put("4700533", "愛知県豊田市鍛治屋敷町");
            put("4701216", "愛知県豊田市和会町");
            put("4442214", "愛知県豊田市桂野町");
            put("4710876", "愛知県豊田市金谷町");
            put("4700364", "愛知県豊田市加納町");
            put("4443223", "愛知県豊田市蕪木町");
            put("4710804", "愛知県豊田市神池町");
            put("4730931", "愛知県豊田市上丘町");
            put("4700421", "愛知県豊田市上川口町");
            put("4442836", "愛知県豊田市上切町");
            put("4442531", "愛知県豊田市上切山町");
            put("4701218", "愛知県豊田市上郷町");
            put("4442314", "愛知県豊田市上小田町");
            put("4442337", "愛知県豊田市上佐切町");
            put("4700322", "愛知県豊田市上高町");
            put("4700462", "愛知県豊田市上渡合町");
            put("4442835", "愛知県豊田市上中町");
            put("4700561", "愛知県豊田市上仁木町");
            put("4442335", "愛知県豊田市上脇町");
            put("4700375", "愛知県豊田市亀首町");
            put("4442213", "愛知県豊田市加茂川町");
            put("4700513", "愛知県豊田市苅萱町");
            put("4710824", "愛知県豊田市河合町");
            put("4442403", "愛知県豊田市川面町");
            put("4700575", "愛知県豊田市川下町");
            put("4710073", "愛知県豊田市川田町");
            put("4412517", "愛知県豊田市川手町");
            put("4710074", "愛知県豊田市川端町");
            put("4710868", "愛知県豊田市神田町");
            put("4443252", "愛知県豊田市神殿町");
            put("4700328", "愛知県豊田市勘八町");
            put("4700542", "愛知県豊田市喜佐平町");
            put("4700411", "愛知県豊田市木瀬町");
            put("4700453", "愛知県豊田市北一色町");
            put("4700573", "愛知県豊田市北大野町");
            put("4442502", "愛知県豊田市北小田町");
            put("4700543", "愛知県豊田市北篠平町");
            put("4710027", "愛知県豊田市喜多町");
            put("4710005", "愛知県豊田市京ケ峰");
            put("4710063", "愛知県豊田市京町");
            put("4442343", "愛知県豊田市霧山町");
            put("4442216", "愛知県豊田市九久平町");
            put("4442804", "愛知県豊田市日下部町");
            put("4700305", "愛知県豊田市国附町");
            put("4442326", "愛知県豊田市国谷町");
            put("4710076", "愛知県豊田市久保町");
            put("4700522", "愛知県豊田市榑俣町");
            put("4443212", "愛知県豊田市黒坂町");
            put("4412524", "愛知県豊田市黒田町");
            put("4442407", "愛知県豊田市桑田和町");
            put("4442325", "愛知県豊田市桑原田町");
            put("4412521", "愛知県豊田市桑原町");
            put("4442221", "愛知県豊田市幸海町");
            put("4710836", "愛知県豊田市鴻ノ巣町");
            put("4710035", "愛知県豊田市小坂町");
            put("4710034", "愛知県豊田市小坂本町");
            put("4700332", "愛知県豊田市越戸町");
            put("4412523", "愛知県豊田市御所貝津町");
            put("4710801", "愛知県豊田市古瀬間町");
            put("4442821", "愛知県豊田市小田町");
            put("4442608", "愛知県豊田市五反田町");
            put("4442521", "愛知県豊田市小町");
            put("4442533", "愛知県豊田市小手沢町");
            put("4710816", "愛知県豊田市琴平町");
            put("4710834", "愛知県豊田市寿町");
            put("4442805", "愛知県豊田市小畑町");
            put("4730926", "愛知県豊田市駒新町");
            put("4443213", "愛知県豊田市小松野町");
            put("4730925", "愛知県豊田市駒場町");
            put("4700306", "愛知県豊田市小峯町");
            put("4710856", "愛知県豊田市衣ケ原");
            put("4710023", "愛知県豊田市挙母町");
            put("4701203", "愛知県豊田市幸町");
            put("4442201", "愛知県豊田市坂上町");
            put("4710066", "愛知県豊田市栄町");
            put("4442814", "愛知県豊田市榊野町");
            put("4710029", "愛知県豊田市桜町");
            put("4442826", "愛知県豊田市笹戸町");
            put("4700352", "愛知県豊田市篠原町");
            put("4442226", "愛知県豊田市幸穂台");
            put("4700504", "愛知県豊田市雑敷町");
            put("4700361", "愛知県豊田市猿投町");
            put("4700564", "愛知県豊田市沢田町");
            put("4442311", "愛知県豊田市沢ノ堂町");
            put("4700402", "愛知県豊田市三箇町");
            put("4710037", "愛知県豊田市三軒町");
            put("4442839", "愛知県豊田市三分山町");
            put("4442516", "愛知県豊田市塩ノ沢町");
            put("4710041", "愛知県豊田市汐見町");
            put("4710802", "愛知県豊田市志賀町");
            put("4700373", "愛知県豊田市四郷町");
            put("4442841", "愛知県豊田市閑羅瀬町");
            put("4700308", "愛知県豊田市枝下町");
            put("4710808", "愛知県豊田市渋谷町");
            put("4442834", "愛知県豊田市島崎町");
            put("4710843", "愛知県豊田市清水町");
            put("4710875", "愛知県豊田市下市場町");
            put("4700422", "愛知県豊田市下川口町");
            put("4442833", "愛知県豊田市下切町");
            put("4442321", "愛知県豊田市下国谷町");
            put("4442336", "愛知県豊田市下佐切町");
            put("4442332", "愛知県豊田市下平町");
            put("4442838", "愛知県豊田市下中町");
            put("4700565", "愛知県豊田市下仁木町");
            put("4710878", "愛知県豊田市下林町");
            put("4700319", "愛知県豊田市下室町");
            put("4443222", "愛知県豊田市下山田代町");
            put("4710851", "愛知県豊田市樹木町");
            put("4700343", "愛知県豊田市浄水町");
            put("4710078", "愛知県豊田市昭和町");
            put("4700403", "愛知県豊田市白川町");
            put("4442327", "愛知県豊田市白倉町");
            put("4710022", "愛知県豊田市白浜町");
            put("4700313", "愛知県豊田市城見町");
            put("4710837", "愛知県豊田市新生町");
            put("4710079", "愛知県豊田市陣中町");
            put("4710044", "愛知県豊田市新町");
            put("4710028", "愛知県豊田市神明町");
            put("4442505", "愛知県豊田市新盛町");
            put("4710822", "愛知県豊田市水源町");
            put("4442816", "愛知県豊田市杉本町");
            put("4442409", "愛知県豊田市菅生町");
            put("4710862", "愛知県豊田市砂町");
            put("4442831", "愛知県豊田市須渕町");
            put("4730905", "愛知県豊田市住吉町");
            put("4700534", "愛知県豊田市李町");
            put("4442524", "愛知県豊田市摺町");
            put("4710844", "愛知県豊田市聖心町");
            put("4442207", "愛知県豊田市石楠町");
            put("4710016", "愛知県豊田市千石町");
            put("4710847", "愛知県豊田市千足町");
            put("4442606", "愛知県豊田市千田町");
            put("4700506", "愛知県豊田市川見町");
            put("4442806", "愛知県豊田市惣田町");
            put("4701217", "愛知県豊田市大成町");
            put("4710057", "愛知県豊田市太平町");
            put("4443221", "愛知県豊田市田折町");
            put("4730921", "愛知県豊田市高丘新町");
            put("4730933", "愛知県豊田市高岡町");
            put("4730922", "愛知県豊田市高岡本町");
            put("4710013", "愛知県豊田市高上");
            put("4710048", "愛知県豊田市高崎町");
            put("4443208", "愛知県豊田市高野町");
            put("4710019", "愛知県豊田市高橋町");
            put("4710069", "愛知県豊田市高原町");
            put("4700376", "愛知県豊田市高町");
            put("4730918", "愛知県豊田市高美町");
            put("4730908", "愛知県豊田市宝町");
            put("4700324", "愛知県豊田市滝見町");
            put("4710077", "愛知県豊田市竹生町");
            put("4442212", "愛知県豊田市滝脇町");
            put("4730906", "愛知県豊田市竹町");
            put("4730913", "愛知県豊田市竹元町");
            put("4710846", "愛知県豊田市田代町");
            put("4442402", "愛知県豊田市竜岡町");
            put("4442802", "愛知県豊田市田津原町");
            put("4443262", "愛知県豊田市立岩町");
            put("4710845", "愛知県豊田市田中町");
            put("4443265", "愛知県豊田市田平沢町");
            put("4442353", "愛知県豊田市田振町");
            put("4710049", "愛知県豊田市田町");
            put("4442605", "愛知県豊田市玉野町");
            put("4700423", "愛知県豊田市田茂平町");
            put("4700354", "愛知県豊田市田籾町");
            put("4700545", "愛知県豊田市千洗町");
            put("4442355", "愛知県豊田市近岡町");
            put("4700318", "愛知県豊田市力石町");
            put("4700316", "愛知県豊田市千鳥町");
            put("4710879", "愛知県豊田市長興寺");
            put("4710831", "愛知県豊田市司町");
            put("4710033", "愛知県豊田市月見町");
            put("4710842", "愛知県豊田市土橋町");
            put("4730932", "愛知県豊田市堤町");
            put("4730939", "愛知県豊田市堤本町");
            put("4442414", "愛知県豊田市葛沢町");
            put("4442526", "愛知県豊田市葛町");
            put("4442419", "愛知県豊田市椿立町");
            put("4442803", "愛知県豊田市坪崎町");
            put("4710059", "愛知県豊田市貞宝町");
            put("4700327", "愛知県豊田市寺下町");
            put("4700544", "愛知県豊田市寺平町");
            put("4710017", "愛知県豊田市寺部町");
            put("4700325", "愛知県豊田市手呂町");
            put("4700326", "愛知県豊田市手呂町樋田");
            put("4710054", "愛知県豊田市天王町");
            put("4710817", "愛知県豊田市渡合町");
            put("4700512", "愛知県豊田市東郷町");
            put("4710045", "愛知県豊田市東新町");
            put("4700535", "愛知県豊田市百月町");
            put("4710008", "愛知県豊田市百々町");
            put("4701202", "愛知県豊田市渡刈町");
            put("4442847", "愛知県豊田市時瀬町");
            put("4710867", "愛知県豊田市常盤町");
            put("4443264", "愛知県豊田市栃立町");
            put("4442514", "愛知県豊田市栃ノ沢町");
            put("4442324", "愛知県豊田市栃本町");
            put("4442302", "愛知県豊田市戸中町");
            put("4710869", "愛知県豊田市十塚町");
            put("4442510", "愛知県豊田市富岡町");
            put("4700304", "愛知県豊田市富田町");
            put("4412526", "愛知県豊田市富永町");
            put("4442224", "愛知県豊田市巴町");
            put("4710826", "愛知県豊田市トヨタ町");
            put("4442203", "愛知県豊田市豊松町");
            put("4442215", "愛知県豊田市中垣内町");
            put("4700312", "愛知県豊田市中金町");
            put("4700315", "愛知県豊田市中切町");
            put("4710021", "愛知県豊田市中島町");
            put("4442517", "愛知県豊田市中立町");
            put("4730927", "愛知県豊田市中田町");
            put("4412514", "愛知県豊田市中当町");
            put("4730923", "愛知県豊田市中根町");
            put("4442504", "愛知県豊田市永野町");
            put("4730904", "愛知県豊田市中町");
            put("4443201", "愛知県豊田市梨野町");
            put("4412515", "愛知県豊田市夏焼町");
            put("4442211", "愛知県豊田市長沢町");
            put("4442205", "愛知県豊田市鍋田町");
            put("4700317", "愛知県豊田市成合町");
            put("4700554", "愛知県豊田市荷掛町");
            put("4700404", "愛知県豊田市西市野々町");
            put("4730936", "愛知県豊田市西岡町");
            put("4730937", "愛知県豊田市西岡町星ケ丘");
            put("4442532", "愛知県豊田市西樫尾町");
            put("4710877", "愛知県豊田市錦町");
            put("4710047", "愛知県豊田市西新町");
            put("4730903", "愛知県豊田市西田町");
            put("4700521", "愛知県豊田市西丹波町");
            put("4700431", "愛知県豊田市西中山町");
            put("4700541", "愛知県豊田市西萩平町");
            put("4700309", "愛知県豊田市西広瀬町");
            put("4700526", "愛知県豊田市西細田町");
            put("4710025", "愛知県豊田市西町");
            put("4710062", "愛知県豊田市西山町");
            put("4710032", "愛知県豊田市日南町");
            put("4442404", "愛知県豊田市怒田沢町");
            put("4412512", "愛知県豊田市野入町");
            put("4700314", "愛知県豊田市野口町");
            put("4442303", "愛知県豊田市野林町");
            put("4710812", "愛知県豊田市野見町");
            put("4710813", "愛知県豊田市野見山町");
            put("4442342", "愛知県豊田市則定町");
            put("4443205", "愛知県豊田市野原町");
            put("4701204", "愛知県豊田市配津町");
            put("4710056", "愛知県豊田市白山町");
            put("4700452", "愛知県豊田市迫町");
            put("4710861", "愛知県豊田市八幡町");
            put("4710051", "愛知県豊田市花丘町");
            put("4443231", "愛知県豊田市花沢町");
            put("4730924", "愛知県豊田市花園町");
            put("4700334", "愛知県豊田市花本町");
            put("4443206", "愛知県豊田市羽布町");
            put("4442218", "愛知県豊田市林添町");
            put("4442313", "愛知県豊田市冷田町");
            put("4700524", "愛知県豊田市日面町");
            put("4710071", "愛知県豊田市東梅坪町");
            put("4442344", "愛知県豊田市東大島町");
            put("4443261", "愛知県豊田市東大林町");
            put("4442413", "愛知県豊田市東大見町");
            put("4442301", "愛知県豊田市東川端町");
            put("4442528", "愛知県豊田市東渡合町");
            put("4442512", "愛知県豊田市東中山町");
            put("4442823", "愛知県豊田市東萩平町");
            put("4700307", "愛知県豊田市東広瀬町");
            put("4700345", "愛知県豊田市東保見町");
            put("4710014", "愛知県豊田市東山町");
            put("4710055", "愛知県豊田市久岡町");
            put("4442506", "愛知県豊田市久木町");
            put("4710075", "愛知県豊田市日之出町");
            put("4710011", "愛知県豊田市平井町");
            put("4700514", "愛知県豊田市平岩町");
            put("4442607", "愛知県豊田市平沢町");
            put("4710065", "愛知県豊田市平芝町");
            put("4443251", "愛知県豊田市平瀬町");
            put("4700331", "愛知県豊田市平戸橋町");
            put("4700523", "愛知県豊田市平畑町");
            put("4710827", "愛知県豊田市平山町");
            put("4710807", "愛知県豊田市広川町");
            put("4710036", "愛知県豊田市広久手町");
            put("4710864", "愛知県豊田市広路町");
            put("4730912", "愛知県豊田市広田町");
            put("4700351", "愛知県豊田市広幡町");
            put("4701215", "愛知県豊田市広美町");
            put("4442333", "愛知県豊田市平折町");
            put("4710841", "愛知県豊田市深田町");
            put("4700441", "愛知県豊田市深見町");
            put("4701214", "愛知県豊田市福受町");
            put("4700451", "愛知県豊田市藤岡飯野町");
            put("4700302", "愛知県豊田市藤沢町");
            put("4412522", "愛知県豊田市武節町");
            put("4710009", "愛知県豊田市扶桑町");
            put("4710004", "愛知県豊田市双美町");
            put("4442401", "愛知県豊田市二タ宮町");
            put("4710821", "愛知県豊田市平和町");
            put("4701201", "愛知県豊田市豊栄町");
            put("4700311", "愛知県豊田市芳友町");
            put("4710809", "愛知県豊田市宝来町");
            put("4700461", "愛知県豊田市北曽木町");
            put("4442503", "愛知県豊田市細田町");
            put("4442222", "愛知県豊田市穂積町");
            put("4710853", "愛知県豊田市細谷町");
            put("4700353", "愛知県豊田市保見ケ丘");
            put("4700344", "愛知県豊田市保見町");
            put("4710046", "愛知県豊田市本新町");
            put("4730938", "愛知県豊田市本田町");
            put("4710848", "愛知県豊田市本地町");
            put("4700363", "愛知県豊田市本徳町");
            put("4730911", "愛知県豊田市本町");
            put("4700362", "愛知県豊田市舞木町");
            put("4710874", "愛知県豊田市前田町");
            put("4730934", "愛知県豊田市前林町");
            put("4700503", "愛知県豊田市前洞町");
            put("4710828", "愛知県豊田市前山町");
            put("4442808", "愛知県豊田市槇本町");
            put("4701212", "愛知県豊田市桝塚東町");
            put("4701213", "愛知県豊田市桝塚西町");
            put("4710865", "愛知県豊田市松ケ枝町");
            put("4442223", "愛知県豊田市松平志賀町");
            put("4442202", "愛知県豊田市松平町");
            put("4700571", "愛知県豊田市松名町");
            put("4700301", "愛知県豊田市松嶺町");
            put("4710053", "愛知県豊田市丸根町");
            put("4710832", "愛知県豊田市丸山町");
            put("4442845", "愛知県豊田市万町町");
            put("4442815", "愛知県豊田市万根町");
            put("4442411", "愛知県豊田市御内町");
            put("4442522", "愛知県豊田市御蔵町");
            put("4442523", "愛知県豊田市実栗町");
            put("4710805", "愛知県豊田市美里");
            put("4710863", "愛知県豊田市瑞穂町");
            put("4710012", "愛知県豊田市水間町");
            put("4710811", "愛知県豊田市御立町");
            put("4700551", "愛知県豊田市三ツ久保町");
            put("4700424", "愛知県豊田市御作町");
            put("4710838", "愛知県豊田市緑ケ丘");
            put("4700371", "愛知県豊田市御船町");
            put("4710038", "愛知県豊田市宮上町");
            put("4710042", "愛知県豊田市宮口町");
            put("4700516", "愛知県豊田市宮代町");
            put("4710819", "愛知県豊田市宮前町");
            put("4710043", "愛知県豊田市宮町");
            put("4710849", "愛知県豊田市美山町");
            put("4710852", "愛知県豊田市御幸町");
            put("4730901", "愛知県豊田市御幸本町");
            put("4710007", "愛知県豊田市美和町");
            put("4442417", "愛知県豊田市室口町");
            put("4710818", "愛知県豊田市室町");
            put("4710825", "愛知県豊田市明和町");
            put("4710024", "愛知県豊田市元城町");
            put("4710854", "愛知県豊田市元町");
            put("4710871", "愛知県豊田市元宮町");
            put("4710806", "愛知県豊田市森町");
            put("4442451", "愛知県豊田市岩神町（足助高等学校）");
            put("4442351", "愛知県豊田市岩神町（その他）");
            put("4700356", "愛知県豊田市八草町");
            put("4710018", "愛知県豊田市社町");
            put("4700525", "愛知県豊田市簗平町");
            put("4710002", "愛知県豊田市矢並町");
            put("4442415", "愛知県豊田市山谷町");
            put("4700321", "愛知県豊田市山中町");
            put("4710833", "愛知県豊田市山之手");
            put("4442412", "愛知県豊田市山ノ中立町");
            put("4700563", "愛知県豊田市遊屋町");
            put("4710068", "愛知県豊田市横山町");
            put("4730916", "愛知県豊田市吉原町");
            put("4442842", "愛知県豊田市余平町");
            put("4442312", "愛知県豊田市四ツ松町");
            put("4710872", "愛知県豊田市竜宮町");
            put("4730907", "愛知県豊田市竜神町");
            put("4442602", "愛知県豊田市連谷町");
            put("4710061", "愛知県豊田市若草町");
            put("4730914", "愛知県豊田市若林東町");
            put("4730917", "愛知県豊田市若林西町");
            put("4730915", "愛知県豊田市若林東町中外根");
            put("4710026", "愛知県豊田市若宮町");
            put("4443211", "愛知県豊田市和合町");
            put("4442527", "愛知県豊田市月原町");
        }
    });

    public static Map<String, String> searchByCode(String postalCode) {
        var postalodeStream = POSTALCODE_MAP.entrySet().stream();
        // 前方一致
        var searchedCodeStream = postalodeStream.filter(entry -> entry.getKey().startsWith(postalCode));
        return searchedCodeStream.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<String, String> searchByAddress(String addressText) {
        var postalodeStream = POSTALCODE_MAP.entrySet().stream();
        // 前方一致
        var searchedCodeStream = postalodeStream.filter(entry -> entry.getValue().startsWith(addressText));
        return searchedCodeStream.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * 検索テスト
     * 
     * @param presearchFunc 検索前に検索ワードを変換する関数
     * @return 検索結果
     */
    private static SearchRes searchTest(Function<String, String> presearchFunc) {
        // POSTALCODE_MAP から 10 件のstreamを取得
        var postalCodeStream = POSTALCODE_MAP.entrySet().stream().limit(10);
        // 配列に変換
        var postalCodeList = postalCodeStream.collect(Collectors.toList());

        // エラー情報を格納するリスト
        var res = new SearchRes();

        for (var entry : postalCodeList) {
            var postalCode = entry.getKey();
            var address = entry.getValue();

            // 郵便番号で検索
            var searchPostalCode = presearchFunc.apply(postalCode);
            var searchedAddressMap = searchByCode(searchPostalCode);

            if (!searchedAddressMap.containsKey(postalCode)) {// 含まれていない
                res.putNotFoundAddress(postalCode, address);
            } else if (searchedAddressMap.size() == 1) {// 1件含まれている
                res.putOneAddress(postalCode, address);
            } else {// 複数件含まれている
                res.putMultiAddress(postalCode, address);
            }

            // 住所で検索
            var searchAddress = presearchFunc.apply(address);
            var searchedPostalCodeMap = searchByAddress(searchAddress);

            if (!searchedPostalCodeMap.containsKey(postalCode)) {// 含まれていない
                res.putNotFoundPostalCode(postalCode, address);
            } else if (searchedPostalCodeMap.size() == 1) {// 1件含まれている
                res.putOnePostalCode(postalCode, address);
            } else {// 複数件含まれている
                res.putMultiPostalCode(postalCode, address);
            }
        }

        return res;
    }

    // 値をそのまま返す
    private static String returnSame(String str) {
        return str;
    }

    // 前方半分だけ返す
    private static String returnForwardHalf(String str) {
        return str.substring(0, Math.ceilDiv(str.length(), 2));
    }

    // 適当な文字列を返す
    private static String returnNotFound(String str) {
        return "This string will not be found in search." + str;
    }

    public static void main(String[] args) {
        // 完全一致検索
        var perfectMatchRes = searchTest(AichiToyotaAddress::returnSame);

        System.out.println("\n=== 完全一致検索 ===");
        if (perfectMatchRes.getNotFoundAddress().isEmpty()) {
            System.out.println("Success: 全ての住所が見つかりました");
        } else {
            System.out.println("Error: 以下の住所が見つかりませんでした");
            perfectMatchRes.getNotFoundAddress().forEach((key, value) -> System.out.println("  " + key + ": " + value));
        }

        if (perfectMatchRes.getMultiAddress().isEmpty()) {
            System.out.println("Success: 複数研見つかった住所はありません");
        } else {
            System.out.println("Error: 以下の住所が複数見つかりました");
            perfectMatchRes.getMultiAddress().forEach((key, value) -> System.out.println("  " + key + ": " + value));
        }

        if (perfectMatchRes.getOneAddress().isEmpty()) {
            System.out.println("Error: 1件だけ見つかった住所はありません");
        } else {
            System.out.println("Success: 以下の住所が1件だけ見つかりました");
            perfectMatchRes.getOneAddress().forEach((key, value) -> System.out.println("  " + key + ": " + value));
        }

        if (perfectMatchRes.getNotFoundPostalCode().isEmpty()) {
            System.out.println("Success: 全ての郵便番号が見つかりました");
        } else {
            System.out.println("Error: 以下の郵便番号が見つかりませんでした");
            perfectMatchRes.getNotFoundPostalCode()
                    .forEach((key, value) -> System.out.println("  " + key + ": " + value));
        }

        if (perfectMatchRes.getMultiPostalCode().isEmpty()) {
            System.out.println("Success: 複数研見つかった郵便番号はありません");
        } else {
            System.out.println("Error: 以下の郵便番号が複数見つかりました");
            perfectMatchRes.getMultiPostalCode().forEach((key, value) -> System.out.println("  " + key + ": " + value));
        }

        if (perfectMatchRes.getOnePostalCode().isEmpty()) {
            System.out.println("Error: 1件だけ見つかった郵便番号はありません");
        } else {
            System.out.println("Success: 以下の郵便番号が1件だけ見つかりました");
            perfectMatchRes.getOnePostalCode().forEach((key, value) -> System.out.println("  " + key + ": " + value));
        }

        // 前方一致検索
        var partialMatchRes = searchTest(AichiToyotaAddress::returnForwardHalf);

        System.out.println("\n=== 前方一致検索 ===");
        if (partialMatchRes.getNotFoundAddress().isEmpty()) {
            System.out.println("Success: 全ての住所が見つかりました");
        } else {
            System.out.println("Error: 以下の住所が見つかりませんでした");
            partialMatchRes.getNotFoundAddress().forEach((key, value) -> System.out.println("  " + key + ": " + value));
        }

        if (partialMatchRes.getNotFoundPostalCode().isEmpty()) {
            System.out.println("Success: 全ての郵便番号が見つかりました");
        } else {
            System.out.println("Error: 以下の郵便番号が見つかりませんでした");
            partialMatchRes.getNotFoundPostalCode()
                    .forEach((key, value) -> System.out.println("  " + key + ": " + value));
        }

        // 見つかってはいけない文字列で検索
        // TODO: 検索対象のMAPを変更できるようにしたい
        var notFoundRes = searchTest(AichiToyotaAddress::returnNotFound);

        System.out.println("\n=== 存在しない文字列で検索 ===");
        if (notFoundRes.getOneAddress().size() > 0 || notFoundRes.getMultiAddress().size() > 0) {
            System.out.println("Error: 以下の住所が見つかりました");
            notFoundRes.getOneAddress().forEach((key, value) -> System.out.println("  " + key + ": " + value));
            notFoundRes.getMultiAddress().forEach((key, value) -> System.out.println("  " + key + ": " + value));
        } else {
            System.out.println("Success: 全ての住所が見つかりませんでした");
        }

        if (notFoundRes.getOnePostalCode().size() > 0 || notFoundRes.getMultiPostalCode().size() > 0) {
            System.out.println("Error: 以下の郵便番号が見つかりました");
            notFoundRes.getOnePostalCode().forEach((key, value) -> System.out.println("  " + key + ": " + value));
            notFoundRes.getMultiPostalCode().forEach((key, value) -> System.out.println("  " + key + ": " + value));
        } else {
            System.out.println("Success: 全ての郵便番号が見つかりませんでした");
        }
    }
}
