package com.concierto.springmvc.dao;

//@Repository("artistaDao")
@Deprecated
public class ArtistaDaoImpl /*extends AbstractDao<Integer, Artista> implements ArtistaDao */
{

/*	@Autowired
	private SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Artista findById(int id) {
		return getByKey(id);
	}

	public void save(Artista artista) {
		persist(artista);

	}

	@Transactional
	public void delete(Artista artista) {
		Query query = currentSession().createQuery("delete Artista where id=:id");
		query.setParameter("id", artista.getId());
		query.executeUpdate();

	}

	@SuppressWarnings("unchecked")
	public List<Artista> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<Artista>) criteria.list();
	}

	@Override
	@Transactional
	public void update(Artista artista) {
		currentSession().update(artista);

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Artista> filtra(Artista artista) {
		String queryTxt = "select model from  Artista model where 1=1";
		if (!"".equals(artista.getNombre()))
			queryTxt += " and lower(nombre) like lower('%" + artista.getNombre() + "%')";

		queryTxt += " order by nombre";
		Query query = currentSession().createQuery(queryTxt);
		return query.list();
	}
*/
}
