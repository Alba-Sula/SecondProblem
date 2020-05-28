import java.util.Date;

public class SchedulesModel{

    public String SchName;
    public String SchDescription;
    public Date SchStart;
    public int IsRepeat;
    public long RepetitionInMinutes;
    public int Duration;

    public SchedulesModel(String SchName, String SchDescription, Date SchStart,int IsRepeat,long RepetitionInMinutes, int Duration ){
        this.SchName = SchName;
        this.SchDescription = SchDescription;
        this.SchStart = SchStart;
        this.IsRepeat = IsRepeat;
        this.RepetitionInMinutes = RepetitionInMinutes;
        this.Duration = Duration;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public String getSchName() {
        return SchName;
    }

    public void setSchName(String schName) {
        SchName = schName;
    }

    public String getSchDescription() {
        return SchDescription;
    }

    public void setSchDescription(String schDescription) {
        SchDescription = schDescription;
    }

    public Date getSchStart() {
        return SchStart;
    }

    public void setSchStart(Date schStart) {
        SchStart = schStart;
    }

    public int isRepeat() {
        return IsRepeat;
    }

    public void setRepeat(int repeat) {
        IsRepeat = repeat;
    }

    public long getRepetitionInMinutes() {
        return RepetitionInMinutes;
    }

    public void setRepetitionInMinutes(long repetitionInMinutes) {
        RepetitionInMinutes = repetitionInMinutes;
    }

    @Override
    public String toString() {
        return "SchedulesModel{" +
                "SchName='" + SchName + '\'' +
                ", SchDescription='" + SchDescription + '\'' +
                ", SchStart=" + SchStart +
                ", IsRepeat=" + IsRepeat +
                ", RepetitionInMinutes=" + RepetitionInMinutes +
                ", Duration=" + Duration +
                '}';
    }
}
