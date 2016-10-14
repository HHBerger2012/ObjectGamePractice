

public class PlayerWeapon
	{
		private String name;
		private int rounds;
		private int reserveRounds;
		private String camo;
		private String origin;
		private String type;
		public String getName()
			{
				return name;
			}
		public void setName(String name)
			{
				this.name = name;
			}
		public int getRounds()
			{
				return rounds;
			}
		public void setRounds(int rounds)
			{
				this.rounds = rounds;
			}
		public int getReserveRounds()
			{
				return reserveRounds;
			}
		public void setReserveRounds(int reserveRounds)
			{
				this.reserveRounds = reserveRounds;
			}
		public String getCamo()
			{
				return camo;
			}
		public void setCamo(String camo)
			{
				this.camo = camo;
			}
		public String getOrigin()
			{
				return origin;
			}
		public void setOrigin(String origin)
			{
				this.origin = origin;
			}
		public String getType()
			{
				return type;
			}
		public void setType(String type)
			{
				this.origin = type;
			}
		public PlayerWeapon(String n,int r, int rr, String c, String o, String t)
		{
			name = n;
			rounds = r;
			reserveRounds = rr;
			camo = c;
			origin = o;
			type = t;
		}
	}
